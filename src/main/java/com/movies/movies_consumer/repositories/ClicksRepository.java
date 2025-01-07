package com.movies.movies_consumer.repositories;

import com.movies.movies_consumer.entities.ClicksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClicksRepository extends JpaRepository<ClicksEntity, Long> {
    Optional<ClicksEntity> findByUserIdAndMovieId(String userId, int movieId);
}
