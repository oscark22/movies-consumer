package com.movies.movies_consumer.repositories;

import com.movies.movies_consumer.entities.MoviesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesRepository extends JpaRepository<MoviesEntity, Long> {
}
