package com.football.league.position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.football.league.position.model.Country;
import com.football.league.position.model.League;
import com.football.league.position.model.LeaguePostionResult;
import com.football.league.position.model.TeamStanding;
import com.football.league.position.service.LeaguePositionService;
 
@RestController
public class LeaguePositionController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LeaguePositionService leaguePositionService;
	
	@RequestMapping("/")
	public List<LeaguePostionResult> leaguePosition()
	{
		List<LeaguePostionResult> resultPosition= new ArrayList<LeaguePostionResult>();
		List<Country> countryList= getCountries();
		
		for(Country ctr: countryList) {
			
			List<League> leagueList= getLeagues(ctr.getCountryId());
			
			for(League leagueObj: leagueList ) {
					
					List<TeamStanding> teamStandList= getTeamStanding(leagueObj.getLeagueId());
					
					for(TeamStanding tstand: teamStandList) {
						resultPosition.add(new LeaguePostionResult(ctr.getCountryId() + "-" + tstand.getCountryName(), 
								tstand.getLeagueId() + "-" + tstand.getLeagueName(),
								tstand.getTeamId() + "-" + tstand.getTeamName(),
								tstand.getOverallLeaguePosition()));
					
				}
			}		
		}
		return resultPosition;
		
	}
	
	private List<Country> getCountries(){
		return new ArrayList<>(Arrays.asList(leaguePositionService.getCountryList()));
	}
	
	private List<League> getLeagues(int countryId){
		return new ArrayList<>(Arrays.asList(leaguePositionService.getLeagueList(countryId)));
	}
	
	private List<TeamStanding> getTeamStanding(int leagueId){
		return new ArrayList<>(Arrays.asList(leaguePositionService.getTeamStandingList(leagueId)));
	}

}
