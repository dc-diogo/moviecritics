package com.example.moviecritics.service;

import com.example.moviecritics.gateway.model.response.MovieResponse;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Service
public class MovieService {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    public MovieResponse getLongestIntervalWinner() {
        return null;
    }

    @PostConstruct
    public void init() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("date", UUID.randomUUID().toString())
                .addLong("JobId",System.currentTimeMillis())
                .addLong("time",System.currentTimeMillis()).toJobParameters();

        JobExecution execution = jobLauncher.run(job, jobParameters);
        System.out.println("STATUS :: "+execution.getStatus());
    }
}
