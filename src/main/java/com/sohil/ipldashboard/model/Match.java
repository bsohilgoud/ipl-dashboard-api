package com.sohil.ipldashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table (name = "matches")
public class Match {
    @Id
    @Column (name = "id")
    long id;
    @Column (name = "city")
    String city;
    @Column (name = "date")
    Date date;
    @Column (name = "season")
    String season;
    @Column (name = "matchNumber")
    String matchNumber;
    @Column (name = "team1")
    String team1;
    @Column (name = "team2")
    String team2;
    @Column (name = "venue")
    String venue;
    @Column (name = "tossWinner")
    String tossWinner;
    @Column (name = "tossDecision")
    String tossDecision;
    @Column (name = "matchWinner")
    String matchWinner;
    @Column (name = "wonBy")
    String wonBy;
    @Column (name = "margin")
    String margin;
    @Column (name = "playerOfMatch")
    String playerOfMatch;
    @Column (name = "team1Players")
    String team1Players;
    @Column (name = "team2Players")
    String team2Players;
    @Column (name = "firstInnings")
    String firstInnings;
    @Column (name = "secondInnings")
    String secondInnings;
    @Column
    String umpire1;
    @Column
    String umpire2;


    public Match() {

    }

    public Match(String city, Date date, String season, String matchNumber, String team1, String team2, String venue, String tossWinner, String tossDecision, String matchWinner, String wonBy, String margin, String playerOfMatch, String team1Players, String team2Players, String firstInnings, String secondInnings, String umpire1, String umpire2) {
        this.city = city;
        this.date = date;
        this.season = season;
        this.matchNumber = matchNumber;
        this.team1 = team1;
        this.team2 = team2;
        this.venue = venue;
        this.tossWinner = tossWinner;
        this.tossDecision = tossDecision;
        this.matchWinner = matchWinner;
        this.wonBy = wonBy;
        this.margin = margin;
        this.playerOfMatch = playerOfMatch;
        this.team1Players = team1Players;
        this.team2Players = team2Players;
        this.firstInnings = firstInnings;
        this.secondInnings = secondInnings;
        this.umpire1 = umpire1;
        this.umpire2 = umpire2;
    }


    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", date=" + date +
                ", season='" + season + '\'' +
                ", matchNumber='" + matchNumber + '\'' +
                ", team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", venue='" + venue + '\'' +
                ", tossWinner='" + tossWinner + '\'' +
                ", tossDecision='" + tossDecision + '\'' +
                ", matchWinner='" + matchWinner + '\'' +
                ", wonBy='" + wonBy + '\'' +
                ", margin='" + margin + '\'' +
                ", player_of_Match='" + playerOfMatch + '\'' +
                ", team1Players=" + team1Players +
                ", team2Players=" + team2Players +
                ", umpire1='" + umpire1 + '\'' +
                ", umpire2='" + umpire2 + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getMatchNumber() {
        return matchNumber;
    }

    public void setMatchNumber(String matchNumber) {
        this.matchNumber = matchNumber;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getTossWinner() {
        return tossWinner;
    }

    public void setTossWinner(String tossWinner) {
        this.tossWinner = tossWinner;
    }

    public String getTossDecision() {
        return tossDecision;
    }

    public void setTossDecision(String tossDecision) {
        this.tossDecision = tossDecision;
    }

    public String getMatchWinner() {
        return matchWinner;
    }

    public void setMatchWinner(String matchWinner) {
        this.matchWinner = matchWinner;
    }

    public String getWonBy() {
        return wonBy;
    }

    public void setWonBy(String wonBy) {
        this.wonBy = wonBy;
    }

    public String getMargin() {
        return margin;
    }

    public void setMargin(String margin) {
        this.margin = margin;
    }

    public String getPlayerOfMatch() {
        return playerOfMatch;
    }

    public void setPlayerOfMatch(String playerOfMatch) {
        this.playerOfMatch = playerOfMatch;
    }

    public String getTeam1Players() {
        return team1Players;
    }

    public void setTeam1Players(String team1Players) {
        this.team1Players = team1Players;
    }

    public String getTeam2Players() {
        return team2Players;
    }

    public void setTeam2Players(String team2Players) {
        this.team2Players = team2Players;
    }

    public String getUmpire1() {
        return umpire1;
    }

    public void setUmpire1(String umpire1) {
        this.umpire1 = umpire1;
    }

    public String getUmpire2() {
        return umpire2;
    }

    public void setUmpire2(String umpire2) {
        this.umpire2 = umpire2;
    }

    public String getFirstInnings() {
        return firstInnings;
    }

    public void setFirstInnings(String firstInnings) {
        this.firstInnings = firstInnings;
    }

    public String getSecondInnings() {
        return secondInnings;
    }

    public void setSecondInnings(String secondInnings) {
        this.secondInnings = secondInnings;
    }

}
