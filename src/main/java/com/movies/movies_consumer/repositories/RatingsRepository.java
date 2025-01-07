package com.movies.movies_consumer.repositories;

import com.movies.movies_consumer.entities.RatingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RatingsRepository extends JpaRepository<RatingsEntity, Long> {
    Optional<RatingsEntity> findByUserIdAndMovieId(String userId, int movieId);
}
