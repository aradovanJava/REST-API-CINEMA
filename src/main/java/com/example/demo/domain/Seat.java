package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class Seat extends BaseEntity {
    @Column(name = "ROW_NAME")
    @Enumerated(EnumType.STRING)
    private RowName rowName;

    @Column(name = "POSITION")
    private Integer positionInRow;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "id")
    private SeatCategory seatCategory;

    @ManyToOne
    @JoinColumn(name="STAGE_ID", nullable=false)
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

    /*
    @Id
    public Integer getId() {
        return super.getId();
    }
    */
}
