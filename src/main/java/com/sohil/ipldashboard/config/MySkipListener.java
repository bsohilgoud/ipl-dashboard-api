package com.sohil.ipldashboard.config;

import com.sohil.ipldashboard.model.MatchDetails;
import org.springframework.batch.core.SkipListener;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.item.file.FlatFileParseException;

public class MySkipListener implements SkipListener<MatchDetails, MatchDetails> {
    @Override
    public void onSkipInRead(Throwable t) {
        if (t instanceof FlatFileParseException) {
            // Handle exceptions related to reading
            FlatFileParseException fpe = (FlatFileParseException) t;
            System.out.println("Error occurred while reading: " + fpe.getMessage());
        }
        // Add custom error handling for other exceptions here
    }

    @Override
    public void onSkipInWrite(MatchDetails item, Throwable t) {
        // Handle exceptions related to writing
        System.out.println("Error occurred while writing: " + t.getMessage());
    }

    @Override
    public void onSkipInProcess(MatchDetails item, Throwable t) {
        // Handle exceptions related to processing
        System.out.println("Error occurred while processing: " + t.getMessage());
    }
}
