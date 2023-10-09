package com.sohil.ipldashboard;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sohil.ipldashboard.model.Match;
import com.sohil.ipldashboard.service.DataCreationService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@Component
public class DataInitializer implements CommandLineRunner {


    @Autowired
    DataCreationService dataCreationService;

    @Autowired
    private ApplicationContext applicationContext;

    private static Logger LOG = LoggerFactory
            .getLogger(DataInitializer.class);
    @Override
    public void run(String... args) throws Exception {
        LOG.info("Trying to load data from CSV file");
        List<Match> totalMatches = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();

        InputStream inputStream = new ClassPathResource("IPL_Matches_2008_2022.csv", this.getClass().getClassLoader()).getInputStream();
        //        Approach - 2:
        //        File file = ResourceUtils.getFile("classpath:IPL_Matcher_2008_2022.csv");
        //        InputStream inputStream = new FileInputStream(file);

        //        Approach - 3:
        //        ResourceLoader resourceLoader = applicationContext;
        //        Resource resource = resourceLoader.getResource("classpath:IPL_Matches_2008_2022.csv");
        //        InputStream inputStream = resource.getInputStream();

        BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

        List<CSVRecord> records = csvParser.getRecords();
        LOG.info("Successfully Loaded CSV data, total records is : " + records.size());
        for (int i=0; i<records.size(); i++) {
            CSVRecord record = records.get(i);
//        for (CSVRecord record : csvParser.getRecords()){
            LOG.info("Inside for loop");
            Match match = new Match();

            match.setId(Long.parseLong(record.get("Id")));
            match.setCity(record.get("City"));
            match.setDate((new SimpleDateFormat("yyyy-MM-dd")).parse(record.get("Date")));
            match.setSeason(record.get("Season"));
            match.setMatchNumber(record.get("MatchNumber"));
            match.setTeam1(record.get("Team1"));
            match.setTeam2(record.get("Team2"));
            match.setVenue(record.get("Venue"));
            match.setTossWinner(record.get("TossWinner"));
            match.setTossDecision(record.get("TossDecision"));
            match.setMatchWinner(record.get("WinningTeam"));
            match.setWonBy(record.get("WonBy"));
            match.setMargin(record.get("Margin"));
            match.setPlayerOfMatch(record.get("Player_of_Match"));
            match.setTeam1Players(record.get("Team1Players"));
            match.setTeam2Players(record.get("Team2Players"));
            //match.setTeam2Players(objectMapper.readValue(record.get("Team2Players"), List.class));
            match.setUmpire1(record.get("Umpire1"));
            match.setUmpire2(record.get("Umpire2"));
            String firstInnings;
            String secondInnings;

            if(match.getTossDecision().equalsIgnoreCase("bat")) {
                firstInnings = match.getTossWinner();
                secondInnings = (match.getTeam1().equals(firstInnings)) ? match.getTeam2() : match.getTeam1();
            } else {
                secondInnings = match.getTossWinner();
                firstInnings = (match.getTeam1().equals(secondInnings)) ? match.getTeam2() : match.getTeam1();
            }

            match.setFirstInnings(firstInnings);
            match.setSecondInnings(secondInnings);

            LOG.info("Adding match with ID : " + match.getId());
            totalMatches.add(match);
        }

        LOG.info("Trying to load " + totalMatches.size() + " match records into ipl database");
        dataCreationService.save(totalMatches);
        LOG.info("Successfully Loaded Data into Database !!!!!!!! Hurry");
    }
}
