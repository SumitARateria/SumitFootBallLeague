package com.football.league.position.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class TeamStanding {

	@JsonProperty("team_id")
	int teamId;

	@JsonProperty("team_name")
	String teamName;

	@JsonProperty("country_name")
	String countryName;

	@JsonProperty("league_id")
	int leagueId;

	@JsonProperty("league_name")
	String leagueName;

	@JsonProperty("overall_league_position")
	int overallLeaguePosition;

	public TeamStanding() {

	}

	public TeamStanding(int teamId, String teamName, String countryName, int leagueId, String leagueName,
			int overallLeaguePosition) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.countryName = countryName;
		this.leagueId = leagueId;
		this.leagueName = leagueName;
		this.overallLeaguePosition = overallLeaguePosition;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public int getOverallLeaguePosition() {
		return overallLeaguePosition;
	}

	public void setOverallLeaguePosition(int overallLeaguePosition) {
		this.overallLeaguePosition = overallLeaguePosition;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public int getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(int leagueId) {
		this.leagueId = leagueId;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

}
