package com.example.moviecritics.gateway.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponse {

    Integer year;

    String title;

    String producersName;

    String studios;

    Boolean winner;

}
