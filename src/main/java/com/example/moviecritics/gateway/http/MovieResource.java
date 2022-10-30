package com.example.moviecritics.gateway.http;

import com.example.moviecritics.gateway.model.response.MovieResponse;
import com.example.moviecritics.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/longest-interval-winner", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieResponse> getLongestIntervalWinnerProducer(){
        return ResponseEntity.ok(movieService.getLongestIntervalWinner());
    }

}
