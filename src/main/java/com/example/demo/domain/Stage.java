package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
public class Stage extends BaseEntity {
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name="CINEMA_ID", nullable=false)
    private Cinema cinema;

    @OneToMany(mappedBy="stage")
    private List<Seat> seatList;

    public Stage(Integer id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
        this.cinema = cinema;
    }

    public Stage(Integer id, String name, String description, Cinema cinema) {
        super(id);
        this.name = name;
        this.description = description;
        this.cinema = cinema;
    }

    @Override
    public String toString() {
        return name;
    }

    /*
    @Id
    public Integer getId() {
        return super.getId();
    }
    */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stage stage)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(name, stage.name) && Objects.equals(seatList, stage.seatList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, seatList);
    }
}
