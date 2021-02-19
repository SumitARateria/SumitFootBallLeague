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
public class LeaguePostionResult {

	@JsonProperty("country_id_name")
	String countryIdName;
	
	@JsonProperty("league_id_name")
	String leagueIdName;
	
	@JsonProperty("team_id_name")
	String teamIdName;
	
	@JsonProperty("overall_league_position")
	String overallLeaguePosition;
	
	public LeaguePostionResult() {
	}

	public LeaguePostionResult(String countryIdName, String leagueIdName, String teamIdName,
			String overallLeaguePosition) {
		super();
		this.countryIdName = countryIdName;
		this.leagueIdName = leagueIdName;
		this.teamIdName = teamIdName;
		this.overallLeaguePosition = overallLeaguePosition;
	}

	public String getCountryIdName() {
		return countryIdName;
	}

	public void setCountryIdName(String countryIdName) {
		this.countryIdName = countryIdName;
	}

	public String getLeagueIdName() {
		return leagueIdName;
	}

	public void setLeagueIdName(String leagueIdName) {
		this.leagueIdName = leagueIdName;
	}

	public String getTeamIdName() {
		return teamIdName;
	}

	public void setTeamIdName(String teamIdName) {
		this.teamIdName = teamIdName;
	}

	public String getOverallLeaguePosition() {
		return overallLeaguePosition;
	}

	public void setOverallLeaguePosition(String overallLeaguePosition) {
		this.overallLeaguePosition = overallLeaguePosition;
	}
	
	
}
