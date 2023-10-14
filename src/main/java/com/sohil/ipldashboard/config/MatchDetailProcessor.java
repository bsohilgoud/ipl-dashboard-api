package com.sohil.ipldashboard.config;

import com.sohil.ipldashboard.model.MatchDetails;
import org.springframework.batch.item.ItemProcessor;

public class MatchDetailProcessor implements ItemProcessor<MatchDetails, MatchDetails> {

    @Override
    public MatchDetails process(MatchDetails matchDetails) throws Exception {
        return matchDetails;
    }
}
