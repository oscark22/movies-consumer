package com.movies.movies_consumer.entities;

import com.movies.movies_consumer.entities.id.RatingsId;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ratings")
@IdClass(RatingsId.class)
public class RatingsEntity {

    @Id
    private String userId;

    @Id
    private int movieId;

    private short rating;
}
