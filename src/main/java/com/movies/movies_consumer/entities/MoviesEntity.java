package com.movies.movies_consumer.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies")
public class MoviesEntity {

    @Id
    private String movieId;
    private String movieName;
}
