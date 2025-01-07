package com.movies.movies_consumer.repositories;

import com.movies.movies_consumer.entities.RecommendationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationsRepository extends JpaRepository<RecommendationsEntity, Long> {
}
