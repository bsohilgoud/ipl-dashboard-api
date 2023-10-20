package com.sohil.ipldashboard.service;

import com.sohil.ipldashboard.DAO.BallToBallDetailsDAO;
import com.sohil.ipldashboard.DAO.BattingDetailsDAO;
import com.sohil.ipldashboard.DAO.BowlingDetailsDAO;
import com.sohil.ipldashboard.DAO.FallOfWicketsDAO;
import com.sohil.ipldashboard.DTO.InningsDTO;
import com.sohil.ipldashboard.repository.MatchDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchDetailsService {

    @Autowired
    MatchDetailsRepository matchDetailsRepository;

    public List<BattingDetailsDAO> getBattingDetails(Long matchId, int innings){
        return matchDetailsRepository.getBattingDetails(matchId, innings);
    }

    public List<BowlingDetailsDAO> getBowlingDetails(Long matchId, int innings){
        return matchDetailsRepository.getBowlingDetails(matchId, innings);
    }

    public List<FallOfWicketsDAO> getFallOfWickets(Long matchId, int innings){
        return matchDetailsRepository.getFallOfWickets(matchId, innings);
    }

    public List<BallToBallDetailsDAO> getBallToBallDetails(Long matchId, int innings){
        return matchDetailsRepository.getBallToBallDetails(matchId, innings);
    }

    public String getBattingTeamWithMatchIDAndInnings(Long matchId, int innings){
        return matchDetailsRepository.getBattingTeamName(matchId, innings);
    }


    public InningsDTO getInningsDetails(Long matchId, int innings) {
        List<BattingDetailsDAO> battingDetails = getBattingDetails(matchId, innings);
        List<BowlingDetailsDAO> bowlingDetails = getBowlingDetails(matchId, innings);
        List<FallOfWicketsDAO> fallOfWickets = getFallOfWickets(matchId, innings);
        List<BallToBallDetailsDAO> ballToBallDetails = getBallToBallDetails(matchId, innings);
        String battingTeam = getBattingTeamWithMatchIDAndInnings(matchId, innings);

        return new InningsDTO(battingDetails, bowlingDetails, fallOfWickets, ballToBallDetails, battingTeam);
    }
}
