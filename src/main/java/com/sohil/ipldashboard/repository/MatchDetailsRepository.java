package com.sohil.ipldashboard.repository;

import com.sohil.ipldashboard.DAO.BattingDetailsDAO;
import com.sohil.ipldashboard.DAO.BowlingDetailsDAO;
import com.sohil.ipldashboard.model.MatchDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MatchDetailsRepository extends JpaRepository<MatchDetails, Long> {


    //TODO: Need to calculate total runs and total balls played, totalBoundaries -> noOfBoundaries
    @Query(value = "SELECT batter AS batsmanName," +
            "COUNT(batsman_run) AS totalBallsPlayed," +
            "SUM(CASE WHEN batsman_run = 0 THEN 1 ELSE 0 END) AS noOfDots," +
            "SUM(CASE WHEN batsman_run = 1 THEN 1 ELSE 0 END) AS noOfOnes," +
            "SUM(CASE WHEN batsman_run = 2 THEN 1 ELSE 0 END) AS noOfTwos," +
            "SUM(CASE WHEN batsman_run = 3 THEN 1 ELSE 0 END) AS noOfThrees," +
            "SUM(CASE WHEN batsman_run = 4 THEN 1 ELSE 0 END) AS noOfFours," +
            "SUM(CASE WHEN batsman_run = 5 THEN 1 ELSE 0 END) AS noOfFives," +
            "SUM(CASE WHEN batsman_run = 6 THEN 1 ELSE 0 END) AS noOfSixes," +
            "SUM(CASE WHEN batsman_run = 4 or batsman_run = 6 THEN 1 ELSE 0 END) AS totalBoundaries" +
            " FROM match_details" +
            " WHERE match_id = :matchId" +
            " AND innings = :innings" +
            " GROUP BY batter;", nativeQuery = true)
    List<BattingDetailsDAO> getBattingDetails(@Param("matchId") Long matchId, @Param("innings") int innings);



    //TODO: Need to update type cast the wicketsTaken to String[] in DAO class
    @Query(value = "SELECT" +
            "  bowler AS bowlerName," +
            "  SUM(is_wicket_delivery) AS noOfWickets," +
            "  COUNT(overs) / 6 AS noOfOvers," +
            "  SUM(total_run) AS totalRuns," +
            "  ROUND(SUM(total_run) /(COUNT(overs)/ 6), 2) AS runRate," +
            "  ARRAY_TO_STRING(ARRAY_REMOVE(ARRAY_AGG(CASE WHEN player_out != 'NA' THEN player_out END), NULL), ',') AS wicketsTaken," +
            "  SUM(CASE WHEN total_run = 4 THEN 1 ELSE 0 END) AS noOfFours," +
            "  SUM(CASE WHEN total_run = 6 THEN 1 ELSE 0 END) AS noOfSixes," +
            "  SUM(extra_runs) As extraRuns" +
            "  FROM match_details" +
            "  WHERE match_id = :matchId" +
            "  AND innings = :innings" +
            "  GROUP BY bowler;", nativeQuery = true)
    List<BowlingDetailsDAO> getBowlingDetails(@Param("matchId") Long matchId, @Param("innings") int innings);
}
