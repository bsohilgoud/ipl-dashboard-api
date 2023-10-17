package com.sohil.ipldashboard.service;

import com.sohil.ipldashboard.DAO.BattingDetailsDAO;
import com.sohil.ipldashboard.DAO.BowlingDetailsDAO;
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

    public void getFallOfWickets(){

    }

    public void getBallToBallDetails(){

    }


    public InningsDTO getInningsDetails(Long matchId, int innings) {
        List<BattingDetailsDAO> battingDetails = getBattingDetails(matchId, innings);
        List<BowlingDetailsDAO> bowlingDetails = getBowlingDetails(matchId, innings);

        return new InningsDTO(battingDetails, bowlingDetails);
    }
}
