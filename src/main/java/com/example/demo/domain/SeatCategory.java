package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Data
@NoArgsConstructor
public class SeatCategory extends BaseEntity {
    private String name;
    private String description;
    public SeatCategory(Integer id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }

    /*
    @Id
    public Integer getId() {
        return super.getId();
    }

     */
}
