package com.example.demo.repository;

import com.example.demo.domain.SeatCategory;

import java.util.List;

public interface SeatCategoryRepository {
    List<SeatCategory> findAll();
    SeatCategory findById(Integer id);
}
