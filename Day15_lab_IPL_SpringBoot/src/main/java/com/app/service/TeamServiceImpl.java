package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.TeamDao;
import com.app.dao.TeamDaoImpl;
@Service @Transactional
public class TeamServiceImpl implements TeamService {
	@Autowired
 private TeamDao tdao;
	@Override
	public List<String> getTeamsAbbrevations() {
		
		List<String> abrList = tdao.getTeamsAbbrevations();
		return abrList ;
	}

}
