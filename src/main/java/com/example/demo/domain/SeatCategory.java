package com.example.demo.domain;

public class SeatCategory extends BaseEntity {
    private String name;
    private String description;
    public SeatCategory(Integer id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }
}
