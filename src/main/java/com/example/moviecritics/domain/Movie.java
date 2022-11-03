package com.example.moviecritics.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "name", length = 4, nullable = false)
    private Integer year;

    @Column(name = "title", nullable = false)
    String title;

    @Column(name = "producers", nullable = false)
    String producersName;

    @Column(name = "studios", nullable = false)
    String studios;

    @Column(name = "has_won", nullable = false)
    Boolean winner;

}
