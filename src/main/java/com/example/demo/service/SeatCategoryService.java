package com.example.demo.service;

import com.example.demo.domain.SeatCategory;

import java.util.List;

public interface SeatCategoryService {
    List<SeatCategory> findAll();

    SeatCategory findById(Integer id);
    void save(SeatCategory newSeatCategory);
    SeatCategory update(SeatCategory seatCategory, Integer originalSeatCategoryId);

    void delete(SeatCategory seat);
}
