package com.football.league.position.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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
import com.football.league.position.model.LeaguePostionResult;
import com.football.league.position.model.Team;
import com.football.league.position.model.TeamStanding;

@Component
public class LeaguePositionServiceImpl implements LeaguePositionService {

	@Autowired
	private RestTemplate restTemplate;
	final String uri = "http://apiv2.apifootball.com/";

	@Override
	public Country[] getCountryList() {

		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(uri).queryParam("action", "get_countries")
				.queryParam("APIkey", "9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978");
		ResponseEntity<Country[]> countryResponse = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET,
				new HttpEntity<>(buildHeaders()), Country[].class);

		return countryResponse.getBody();
	}

	@Override
	public League[] getLeagueList(int countryId) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(uri).queryParam("action", "get_leagues")
				.queryParam("country_id", countryId)
				.queryParam("APIkey", "9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978");
		ResponseEntity<League[]> leagueResponse = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET,
				new HttpEntity<>(buildHeaders()), League[].class);

		return leagueResponse.getBody();
	}

	@Override
	public Team[] getTeamList(int leagueId) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(uri).queryParam("action", "get_teams")
				.queryParam("league_id", leagueId)
				.queryParam("APIkey", "9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978");
		ResponseEntity<Team[]> teamResponse = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET,
				new HttpEntity<>(buildHeaders()), Team[].class);

		return teamResponse.getBody();
	}

	@Override
	public TeamStanding[] getTeamStandingList(int leagueId) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(uri).queryParam("action", "get_standings")
				.queryParam("league_id", leagueId)
				.queryParam("APIkey", "9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978");
		ResponseEntity<TeamStanding[]> teamStandResponse = restTemplate.exchange(uriBuilder.toUriString(),
				HttpMethod.GET, new HttpEntity<>(buildHeaders()), TeamStanding[].class);

		return teamStandResponse.getBody();
	}

	HttpHeaders buildHeaders() {
		HttpHeaders headers = new HttpHeaders();
		// headers.setContentType(MediaType.APPLICATION_JSON);
		// headers.set("action", actionType);
		headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		// headers.set("APIkey",
		// "9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978");

		return headers;
	}

	public List<LeaguePostionResult> getLeaguePositionResults() {
		List<LeaguePostionResult> resultPosition = new ArrayList<LeaguePostionResult>();
		Country[] countryList = getCountryList();
		
		Arrays.asList(countryList).stream().forEach(ctr -> {
		League[] leagueList = getLeagueList(ctr.getCountryId());
		Arrays.asList(leagueList).stream().forEach(leagueObj -> {
				TeamStanding[] teamStandList = getTeamStandingList(leagueObj.getLeagueId());
				Arrays.asList(teamStandList).stream().forEach(tstand -> {
					resultPosition.add(new LeaguePostionResult(ctr.getCountryId() + "-" + tstand.getCountryName(),
							tstand.getLeagueId() + "-" + tstand.getLeagueName(),
							tstand.getTeamId() + "-" + tstand.getTeamName(), tstand.getOverallLeaguePosition()));
				});
			});
		});

		return resultPosition;
	}
}
