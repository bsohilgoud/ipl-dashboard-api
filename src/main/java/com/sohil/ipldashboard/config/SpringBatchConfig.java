package com.sohil.ipldashboard.config;

import com.sohil.ipldashboard.IpldashboardApplication;
import com.sohil.ipldashboard.model.MatchDetails;
import com.sohil.ipldashboard.repository.MatchDetailsRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@AllArgsConstructor
@EnableBatchProcessing
public class SpringBatchConfig {

    JobBuilderFactory jobBuilderFactory;
    StepBuilderFactory stepBuilderFactory;

    @Autowired
    MatchDetailsRepository matchDetailsRepository;

    private static Logger LOG = LoggerFactory.getLogger(SpringBatchConfig.class);



    @Bean
    FlatFileItemReader reader(){
        FlatFileItemReader flatFileItemReader = new FlatFileItemReader();
        flatFileItemReader.setLineMapper(getLineMapper());
        flatFileItemReader.setResource(new ClassPathResource("IPL_Ball_by_Ball_2008_2022.csv", IpldashboardApplication.class.getClass().getClassLoader()));
        flatFileItemReader.setLinesToSkip(1);

        return flatFileItemReader;
    }

    private DefaultLineMapper getLineMapper(){
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setNames("ID","innings","overs","ballnumber","batter","bowler","non-striker","extra_type","batsman_run","extras_run","total_run","non_boundary","isWicketDelivery","player_out","kind","fielders_involved","BattingTeam");
        lineTokenizer.setStrict(false);

        BeanWrapperFieldSetMapper<MatchDetails> mapper = new BeanWrapperFieldSetMapper<>();
        mapper.setTargetType(MatchDetails.class);


        DefaultLineMapper defaultLineMapper = new DefaultLineMapper();
        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(mapper);

        return defaultLineMapper;
    }

    @Bean
    MatchDetailProcessor processor(){
        return new MatchDetailProcessor();
    }

    @Bean
    RepositoryItemWriter<MatchDetails> writer(){
        RepositoryItemWriter<MatchDetails> itemWriter = new RepositoryItemWriter<>();
        itemWriter.setRepository(matchDetailsRepository);
        itemWriter.setMethodName("save");

        return itemWriter;
    }


    @Bean
    Step matchDetailsStep(){
//        return stepBuilderFactory.get("Match_Details_Step").allowStartIfComplete(true).<MatchDetails, MatchDetails>chunk(50000)
        return stepBuilderFactory.get("Match_Details_Step").<MatchDetails, MatchDetails>chunk(100000)
                .reader(reader())
                .processor(processor())
                .writer(writer())
//                .faultTolerant()
//                .skip(FlatFileItemReader.class)
//                .skipLimit(10)
//                .listener(new MySkipListener())
                .build();
    }

    @Bean
    Job matchDetailsBatchJob(){
        return jobBuilderFactory.get("Match_Details_Job").start(matchDetailsStep()).build();
    }

}
