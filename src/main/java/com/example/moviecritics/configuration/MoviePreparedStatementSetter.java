package com.example.moviecritics.configuration;

import com.example.moviecritics.domain.Movie;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MoviePreparedStatementSetter implements ItemPreparedStatementSetter<Movie> {
    @Override
    public void setValues(Movie item, PreparedStatement ps) throws SQLException {
        ps.setInt(1, item.getYear());
        ps.setString(2, item.getTitle());
        ps.setString(3, item.getProducers());
        ps.setString(4, item.getStudios());
        ps.setBoolean(5, item.getWinner());
    }
}
