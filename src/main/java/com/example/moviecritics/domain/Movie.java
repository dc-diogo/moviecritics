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

    @Column(name = "_year", nullable = false)
    private Integer year;

    @Column(name = "title", nullable = false)
    String title;

    @Column(name = "producers", nullable = false)
    String producers;

    @Column(name = "studios", nullable = false)
    String studios;

    @Column(name = "winner", nullable = false)
    Boolean winner;

}
