package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Cinema extends BaseEntity {

    private String name;
    private String address;

    public Cinema(Integer id, String name, String address) {
        super(id);
        this.name = name;
        this.address = address;
    }

}
