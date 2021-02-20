package com.football.league.position.service;

import java.util.List;

import com.football.league.position.model.Country;
import com.football.league.position.model.League;
import com.football.league.position.model.Team;
import com.football.league.position.model.TeamStanding;

public interface LeaguePositionService {
	
	public Country[] getCountryList();
	public League[] getLeagueList(int countryId);
	public Team[] getTeamList(int leagueId);
	public TeamStanding[] getTeamStandingList(int leagueId);
	

}
