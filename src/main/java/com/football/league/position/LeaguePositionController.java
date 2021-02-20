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
	private LeaguePositionService leaguePositionService;
	
	@RequestMapping("/")
	public List<LeaguePostionResult> leaguePosition(){	
		return leaguePositionService.getLeaguePositionResults();
		
	}

}
