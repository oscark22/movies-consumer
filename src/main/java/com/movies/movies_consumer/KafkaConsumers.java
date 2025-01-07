package com.movies.movies_consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movies.movies_consumer.entities.ClicksEntity;
import com.movies.movies_consumer.entities.RatingsEntity;
import com.movies.movies_consumer.repositories.ClicksRepository;
import com.movies.movies_consumer.repositories.RatingsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class KafkaConsumers {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ClicksRepository clicksRepository;

    @Autowired
    private RatingsRepository ratingsRepository;

    @KafkaListener(topics = "clicks")
    public void listenClicksTopic(String msg) throws JsonProcessingException {
        log.info("Received clicks topic msg: {}", msg);
        ClicksEntity click = objectMapper.readValue(msg, ClicksEntity.class);
        Optional<ClicksEntity> existingEntity = clicksRepository.findByUserIdAndMovieId(click.getUserId(), click.getMovieId());

        if (existingEntity.isPresent()) {
            ClicksEntity updatedEntity = existingEntity.get();
            updatedEntity.setClicks(updatedEntity.getClicks() + 1);
            clicksRepository.save(updatedEntity);
            log.info("Click instance found. Saved updated entity into db: {}", updatedEntity);
        } else {
            click.setClicks(0);
            clicksRepository.save(click);
            log.info("Click saved into db: {}", click);
        }
    }

    @KafkaListener(topics = "ratings")
    public void listenRatingsTopic(String msg) throws JsonProcessingException {
        log.info("Received ratings topic msg: {}", msg);
        RatingsEntity rating = objectMapper.readValue(msg, RatingsEntity.class);
        Optional<RatingsEntity> existingEntity = ratingsRepository.findByUserIdAndMovieId(rating.getUserId(), rating.getMovieId());

        if (existingEntity.isPresent()) {
            RatingsEntity updatedEntity = existingEntity.get();
            updatedEntity.setRating(rating.getRating());
            ratingsRepository.save(updatedEntity);
            log.info("Rating instance found. Saved updated entity into db: {}", updatedEntity);
        } else {
            ratingsRepository.save(rating);
            log.info("Rating saved into db: {}", rating);
        }
    }
}
