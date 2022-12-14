package com.example.moviecritics;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.*")
@EnableBatchProcessing
public class MoviecriticsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoviecriticsApplication.class, args);
    }

}
