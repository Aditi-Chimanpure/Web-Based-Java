package com.app.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.PlayerDao;
@Service @Transactional
public class PlayerServiceImpl implements PlayerService {
	@Autowired
	private PlayerDao pDao;

	@Override
	public String addPlayer(String fn, String ln, LocalDate dob, Double avg, int wickets, String my_team) {
		String msg =pDao.addPlayer( fn,  ln, dob,  avg,  wickets, my_team);
		
		return msg;
	}
	

}
