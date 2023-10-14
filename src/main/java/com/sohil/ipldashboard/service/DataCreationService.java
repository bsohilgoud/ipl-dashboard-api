package com.sohil.ipldashboard.service;


import com.sohil.ipldashboard.model.Match;
import com.sohil.ipldashboard.repository.MatchDetailsRepository;
import com.sohil.ipldashboard.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataCreationService {
    @Autowired
    MatchRepository matchRepository;

    public void save(List<Match> matchList){
        matchRepository.saveAll(matchList);
    }

}
