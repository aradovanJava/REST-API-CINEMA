package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Film extends BaseEntity {

    private String name;
    private String director;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    @Enumerated(EnumType.STRING)
    private Genre genre;
    private Short duration;
}
