package com.football.league.position.service;

import java.util.List;

import com.football.league.position.model.Country;
import com.football.league.position.model.League;
import com.football.league.position.model.Team;
import com.football.league.position.model.TeamStanding;

public interface LeaguePositionService {
	
	public List<Country> getCountryList();
	public List<League> getLeagueList(int countryId);
	public List<Team> getTeamList(int leagueId);
	public List<TeamStanding> getTeamStandingList(int leagueId);
	

}
