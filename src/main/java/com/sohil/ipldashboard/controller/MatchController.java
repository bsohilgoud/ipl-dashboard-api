package com.sohil.ipldashboard.controller;

import com.sohil.ipldashboard.DTO.TeamDetailsDTO;
import com.sohil.ipldashboard.model.Match;
import com.sohil.ipldashboard.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class MatchController {
    @Autowired
    MatchService matchService;

    @GetMapping("/teams")
    public List<String> getTeamNames(){
        return matchService.getTeams();
    }

    @RequestMapping("/teams/{teamName}")
    public TeamDetailsDTO getMatches(@PathVariable String teamName){
        List<Match> matches = matchService.getAllMatches(teamName);
        String totalWins = matchService.getTotalWinsOfTeam(teamName);
        TeamDetailsDTO teamDetailsDTO = new TeamDetailsDTO();
        teamDetailsDTO.setMatches(matches);
        teamDetailsDTO.setTeamName(teamName);
        teamDetailsDTO.setTotalMatches(matches.size());
        teamDetailsDTO.setTotalWins(totalWins);

        return teamDetailsDTO;
    }

    @RequestMapping("/teams/{teamName}/seasons/")
    public List<String> getMatchesOfSeason(@PathVariable String teamName){
        return matchService.getSeasonsOfMatch(teamName);
    }

    @RequestMapping("/teams/{teamName}/season/{seasonNo}")
    public List<Match> getMatchesOfSeason(@PathVariable String teamName, @PathVariable String seasonNo){
        return matchService.getMatchesOfSeason(teamName, seasonNo);
    }

}
