package com.football.league.position.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.football.league.position.model.Country;
import com.football.league.position.model.League;
import com.football.league.position.model.Team;
import com.football.league.position.model.TeamStanding;

@Component
public class LeaguePositionServiceImpl implements LeaguePositionService{
	
	@Autowired
	private RestTemplate restTemplate;
	final String uri= "http://apiv2.apifootball.com/";

	@Override
	public List<Country> getCountryList() {
		
		HttpEntity<List<Country>>  countryReq= new HttpEntity<>(buildHeaders());
		UriComponentsBuilder uriBuilder= UriComponentsBuilder.fromHttpUrl(uri)
				.queryParam("action", "get_countries");
		ResponseEntity<List<Country>> countryResponse= restTemplate.exchange(uriBuilder.toUriString(),
				HttpMethod.GET, countryReq, new ParameterizedTypeReference<List<Country>>() {
		});
	
		return countryResponse.getBody();
	}

	@Override
	public List<League> getLeagueList(int countryId) {
		HttpEntity<List<League>>  leagueReq= new HttpEntity<>(buildHeaders());
		UriComponentsBuilder uriBuilder= UriComponentsBuilder.fromHttpUrl(uri)
				.queryParam("action", "get_leagues")
				.queryParam("country_id", countryId);
		ResponseEntity<List<League>> leagueResponse= restTemplate.exchange(uriBuilder.toUriString(),
				HttpMethod.GET, leagueReq, new ParameterizedTypeReference<List<League>>() {
		});
	
		return leagueResponse.getBody();
	}

	@Override
	public List<Team> getTeamList(int leagueId) {
		HttpEntity<List<Team>>  teamReq= new HttpEntity<>(buildHeaders());
		UriComponentsBuilder uriBuilder= UriComponentsBuilder.fromHttpUrl(uri)
				.queryParam("action", "get_teams")
				.queryParam("league_id", leagueId);
		ResponseEntity<List<Team>> teamResponse= restTemplate.exchange(uriBuilder.toUriString(),
				HttpMethod.GET, teamReq, new ParameterizedTypeReference<List<Team>>() {
		});
	
		return teamResponse.getBody();
	}

	@Override
	public List<TeamStanding> getTeamStandingList(int leagueId) {
		HttpEntity<List<TeamStanding>>  teamStandReq= new HttpEntity<>(buildHeaders());
		UriComponentsBuilder uriBuilder= UriComponentsBuilder.fromHttpUrl(uri)
				.queryParam("action", "get_standings")
				.queryParam("league_id", leagueId);
		ResponseEntity<List<TeamStanding>> teamStandResponse= restTemplate.exchange(uriBuilder.toUriString(),
				HttpMethod.GET, teamStandReq, new ParameterizedTypeReference<List<TeamStanding>>() {
		});
	
		return teamStandResponse.getBody();
	}
	
	HttpHeaders buildHeaders() {
		HttpHeaders headers= new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		//headers.set("action", actionType);
		headers.set("APIkey", "9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978");
		
		return headers;
	}
}
