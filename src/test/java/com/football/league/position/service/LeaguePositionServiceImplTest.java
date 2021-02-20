package com.football.league.position.service;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.football.league.position.model.Country;
import com.football.league.position.model.League;
import com.football.league.position.model.TeamStanding;

@RunWith(MockitoJUnitRunner.Silent.class)
public class LeaguePositionServiceImplTest {
	
	@Mock
	private RestTemplate restTemplate;
	
	@Mock
	private Country ctr;
	
	@Mock
	private League league;
	
	@Mock
	private TeamStanding teamStanding;
	
	@Before
	public void init() {
		
	}
	
	@Test
	public void testCountryListSuccess() {
		
		when(restTemplate.exchange(ArgumentMatchers.anyString(), ArgumentMatchers.any(), 
				 ArgumentMatchers.any(), ArgumentMatchers.<Class<List<Country>>>any()))
				.thenReturn(new ResponseEntity(new ArrayList().add(new Country(1, "USA")), HttpStatus.ACCEPTED));
		
		String country= ctr.getCountryName() ;
		assertTrue(country.equalsIgnoreCase("USA"));
	}
	
	@Test
	public void testLeagueListSuccess() {
		
		when(restTemplate.exchange(ArgumentMatchers.anyString(), ArgumentMatchers.any(), 
				 ArgumentMatchers.any(), ArgumentMatchers.<Class<List<League>>>any()))
				.thenReturn(new ResponseEntity(new ArrayList().add(new League(4324, "LeagueTest")), HttpStatus.ACCEPTED));
		
		String leagueName= league.getLeagueName() ;
		assertTrue(leagueName.equalsIgnoreCase("LeagueTest"));
	}
	
	@Test
	public void testTeamStandingListSuccess() {
		
		when(restTemplate.exchange(ArgumentMatchers.anyString(), ArgumentMatchers.any(), 
				 ArgumentMatchers.any(), ArgumentMatchers.<Class<List<TeamStanding>>>any()))
				.thenReturn(new ResponseEntity(new ArrayList().add(new TeamStanding(1, "USA", "LeagueTest", 2421, "TeamTest", 3)), HttpStatus.ACCEPTED));
		
		int teamPostiton= teamStanding.getOverallLeaguePosition();
		assertTrue(teamPostiton == 3);
	}

}
