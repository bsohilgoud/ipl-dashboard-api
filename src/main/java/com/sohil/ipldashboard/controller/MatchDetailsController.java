package com.sohil.ipldashboard.controller;

import com.sohil.ipldashboard.DTO.InningsDTO;
import com.sohil.ipldashboard.DTO.MatchDetailsDTO;
import com.sohil.ipldashboard.service.MatchDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class MatchDetailsController {

    @Autowired
    MatchDetailsService matchDetailsService;

    @RequestMapping("/matchDetails/{matchId}")
    public MatchDetailsDTO getMatchDetails(@PathVariable Long matchId) {
        //TODO: Added for testing need to remove during deployment.
        matchId = (matchId == -1) ? matchId : 1312200;

//        return matchDetailsService.getBowlingDetails(matchId, 1);

        InningsDTO firstInnings = matchDetailsService.getInningsDetails(matchId, 1);
        InningsDTO secondInnings = matchDetailsService.getInningsDetails(matchId, 2);

        MatchDetailsDTO matchDetailsDTO = new MatchDetailsDTO();
        matchDetailsDTO.setFirstInnings(firstInnings);
        matchDetailsDTO.setSecondInnings(secondInnings);
        matchDetailsDTO.setMatchId(matchId);

        return matchDetailsDTO;
    }

}
