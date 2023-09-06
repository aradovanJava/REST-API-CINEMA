package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Seat extends BaseEntity {
    private RowName rowName;
    private Integer positionInRow;
    private SeatCategory seatCategory;
    private Stage stage;

    public Seat(Integer id, RowName rowName, Integer positionInRow) {
        super(id);
        this.rowName = rowName;
        this.positionInRow = positionInRow;
    }

    public Seat(Integer id, RowName rowName, Integer positionInRow, SeatCategory seatCategory, Stage stage) {
        super(id);
        this.rowName = rowName;
        this.positionInRow = positionInRow;
        this.seatCategory = seatCategory;
        this.stage = stage;
    }
}
