package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat extends BaseEntity {
    private String rowName;
    private Integer positionInRow;

    public Seat(Long id, String rowName, Integer positionInRow) {
        super(id);
        this.rowName = rowName;
        this.positionInRow = positionInRow;
    }
}
