package com.sohil.ipldashboard.DTO;

import com.sohil.ipldashboard.model.Match;

import java.util.List;


public class TeamDetailsDTO {
    String teamName;
    int totalMatches;
    String totalWins;
    List<Match> matches;

    public TeamDetailsDTO(){

    }

    public TeamDetailsDTO(String teamName, int totalMatches, String totalWins, List<Match> matches) {
        this.teamName = teamName;
        this.totalMatches = totalMatches;
        this.totalWins = totalWins;
        this.matches = matches;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTotalMatches() {
        return totalMatches;
    }

    public void setTotalMatches(int totalMatches) {
        this.totalMatches = totalMatches;
    }

    public String getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(String totalWins) {
        this.totalWins = totalWins;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}

