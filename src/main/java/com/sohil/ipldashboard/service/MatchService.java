package com.sohil.ipldashboard.service;

import com.sohil.ipldashboard.model.Match;
import com.sohil.ipldashboard.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    @Autowired
    MatchRepository matchRepository;

    public List<Match> getAllMatches(String teamName) {
        return matchRepository.findMatchesByTeam1(teamName);
    }

    public List<String> getTeams(){
        return matchRepository.findDistinctTeamNames();
    }

    public List<Match> getMatchesOfSeason(String teamName, String seasonNo) {
        return matchRepository.getMatchesByTeam1WhereSeasonEquals(teamName, seasonNo);
    }

    public String getTotalWinsOfTeam(String teamName) {
        return matchRepository.getTotalWinsOfTeam(teamName);
    }

    public List<String> getSeasonsOfMatch(String teamName) {
        return matchRepository.getSeasonsOfTeam(teamName);
    }
}
