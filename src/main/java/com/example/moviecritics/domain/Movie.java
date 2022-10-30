package com.example.moviecritics.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {

    Integer year;

    String title;

    String producersName;

    String studios;

    Boolean winner;

}
