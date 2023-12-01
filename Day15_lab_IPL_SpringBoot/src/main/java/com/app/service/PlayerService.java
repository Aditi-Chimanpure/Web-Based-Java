package com.app.service;

import java.time.LocalDate;

public interface PlayerService {

	String addPlayer(String fn, String ln, LocalDate dob, Double avg, int wickets, String my_team);

}
