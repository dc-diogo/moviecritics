package com.example.moviecritics.configuration;

import com.example.moviecritics.domain.Movie;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
public class JobConfiguration {
        @Autowired
        public JobBuilderFactory jobBuilderFactory;

        @Autowired
        public StepBuilderFactory stepBuilderFactory;

        @Autowired
        public DataSource dataSource;

        @Bean
        public FlatFileItemReader<Movie> movieItemReader() {
            FlatFileItemReader<Movie> reader = new FlatFileItemReader<>();
            reader.setLinesToSkip(1);
            reader.setResource(new ClassPathResource("movielist.csv"));

            DefaultLineMapper<Movie> customerLineMapper = new DefaultLineMapper<>();

            DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
            tokenizer.setDelimiter(";");
            tokenizer.setNames("year", "title", "studios", "producers", "winner");

            customerLineMapper.setLineTokenizer(tokenizer);
            customerLineMapper.setFieldSetMapper(new MovieFieldSetMapper());
            customerLineMapper.afterPropertiesSet();
            reader.setLineMapper(customerLineMapper);
            return reader;
        }

        @SuppressWarnings({ "rawtypes", "unchecked" })
        @Bean
        public JdbcBatchItemWriter<Movie> movieItemWriter() {
            JdbcBatchItemWriter<Movie> itemWriter = new JdbcBatchItemWriter<>();

            itemWriter.setDataSource(this.dataSource);

            itemWriter.setSql("INSERT INTO MOVIE (_year, title, producers, studios, winner) VALUES (?, ?, ?, ?, ?)");
            itemWriter.setItemPreparedStatementSetter(new MoviePreparedStatementSetter());

            return itemWriter;
        }

        @Bean
        public Step step1() {
            return stepBuilderFactory.get("step1")
                    .<Movie, Movie>chunk(10)
                    .reader(movieItemReader())
                    .writer(movieItemWriter())
                    .build();
        }

        @Bean
        public Job job() {
            return jobBuilderFactory.get("job")
                    .start(step1())
                    .build();
        }

}
