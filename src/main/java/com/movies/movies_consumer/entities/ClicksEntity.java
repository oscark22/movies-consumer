package com.movies.movies_consumer.entities;

import com.movies.movies_consumer.entities.id.ClicksId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "clicks")
@IdClass(ClicksId.class)
public class ClicksEntity {

    @Id
    private String userId;

    @Id
    private int movieId;

    private int clicks;
}
