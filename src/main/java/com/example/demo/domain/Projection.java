package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Projection extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FILM_ID", referencedColumnName = "id")
    private Film film;

    @Column(name = "DATE_AND_TIME")
    private LocalDateTime dateAndTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "STAGE_ID", referencedColumnName = "id")
    private Stage stage;

}
