package com.app.dao;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Player;
import com.app.pojos.Team;
@Repository
public class PlayerDaoImpl implements PlayerDao {

	@PersistenceContext
	private EntityManager mgr;
	@Autowired
	TeamDao tDao;

	@Override
	public String addPlayer(String fn, String ln, LocalDate dob, Double avg, int wickets, String my_team) {
		// String firstName, String lastName, LocalDate dob, double battingAvg, int
		// wicketsTaken
		Player p = new Player(fn, ln, dob, avg, wickets);
		String jpql = "select t from Team t where t.abbreviation=:abr";
		int age = Period.between(dob, LocalDate.now()).getYears();
		 Team t = mgr.createQuery(jpql, Team.class).setParameter("abr",my_team).getSingleResult();
		 if(t.getMaxAge()<age)
			 return "Age criteria does not fullfill";
		 if(t.getBattingAvg()>p.getBattingAvg())
			 return "Batting avg criteria does not fullfill";
		 if(t.getWicketsTaken()>p.getWicketsTaken())
			 return "minimum wicket criteria does not fullfill";
		 t.addPlayer(p);
		return "Player added successfully"; 
	}

}
