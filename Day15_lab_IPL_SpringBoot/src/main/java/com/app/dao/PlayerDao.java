package com.app.dao;

import java.time.LocalDate;

public interface PlayerDao {

	String addPlayer(String fn, String ln, LocalDate dob, Double avg, int wickets, String my_team);

}
