package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Cinema extends BaseEntity {

    private String name;
    private String address;

    @OneToMany(mappedBy="cinema")
    List<Stage> stageList;

    public Cinema(Integer id, String name, String address) {
        super(id);
        this.name = name;
        this.address = address;
    }

    /*
    @Id
    public Integer getId() {
        return super.getId();
    }
     */

}
