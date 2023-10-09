package com.sohil.ipldashboard.repository;
import com.sohil.ipldashboard.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, String> {

    @Query("SELECT DISTINCT team1 from Match")
    List<String> findDistinctTeamNames();

    @Query("SELECT m from Match m WHERE m.team1=:teamName OR m.team2=:teamName")
    List<Match> findMatchesByTeam1(@Param("teamName") String teamName);

    @Query("SELECT m from Match m WHERE m.season=:seasonNo AND (m.team1=:teamName OR m.team2=:teamName)")
    List<Match> getMatchesByTeam1WhereSeasonEquals(@Param("teamName") String teamName,@Param("seasonNo") String seasonNo);

    @Query("SELECT COUNT(id) from Match m WHERE m.matchWinner=:teamName")
    String getTotalWinsOfTeam(@Param("teamName") String teamName);

    @Query("SELECT DISTINCT season from Match m WHERE m.team1=:teamName OR m.team2=:teamName ORDER BY season DESC")
    List<String> getSeasonsOfTeam(@Param("teamName") String teamName);
}
