package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.pojos.Team;
import com.app.service.TeamService;
@Controller

public class TeamController {
	public TeamController()
	{
		System.out.println("In constructor : " + getClass().getName());
	}
	
	@Autowired(required = true)
	private TeamService tSer;
	
@GetMapping("/")
	public String listTeamAbr(Model map)
	{
		System.out.println("in teams/list ");
		List<String> team_list = tSer.getTeamsAbbrevations();
		for(String t : team_list)
		{
			System.out.println(t);
		}
		map.addAttribute("team_list",tSer.getTeamsAbbrevations());
		
		
		return "/teams/add_player_form";//AVN : /WEB-INF/views/teams/list.jsp
		//impl : model map 
	}

}
