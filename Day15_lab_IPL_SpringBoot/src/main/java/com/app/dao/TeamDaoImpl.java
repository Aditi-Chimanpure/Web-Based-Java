package com.app.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
@Repository
public class TeamDaoImpl implements TeamDao {
	
	@PersistenceContext
	private EntityManager mgr;
	
	@Override
	public List<String> getTeamsAbbrevations() {
		
		List<String> abbreviations = null;
		String jpql = "select t.abbreviation from Team t";
		// 1. get Session from SF
		return mgr.createQuery(jpql,String.class).getResultList();
	}

	private Object getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
