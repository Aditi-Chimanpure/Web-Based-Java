package com.app.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.service.PlayerService;

@Controller
@RequestMapping("/players")
public class PlayerController {
	public PlayerController()
	{
		System.out.println("In constructor : " + getClass().getName());
	}
	
	@Autowired(required = true)
	PlayerService pSer;
	
	@PostMapping("/add")
	
	
	public String addPlayer(@RequestParam String fn, @RequestParam String ln,@RequestParam String  dob, @RequestParam Double avg,@RequestParam int wickets, @RequestParam String my_team , Model map)
	{
		LocalDate vDob=LocalDate.parse(dob);
		String msg = pSer.addPlayer(fn,ln,vDob,avg,wickets,my_team);
		map.addAttribute("msg",msg);
		
		return "/players/add";
		
	}
}
