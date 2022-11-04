package com.example.moviecritics.configuration;

import com.example.moviecritics.domain.Movie;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

@Component
public class MovieFieldSetMapper implements FieldSetMapper<Movie> {

    @Override
    public Movie mapFieldSet(FieldSet fieldSet) throws BindException {
        return new Movie(0L,
                fieldSet.readInt("year"),
                fieldSet.readString("title"),
                fieldSet.readString("producers"),
                fieldSet.readString("studios"),
                fieldSet.readString("winner").equals("yes")
        );
    }

}
