package com.example.demo.repository;

import com.example.demo.domain.SeatCategory;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaSeatCategoryRepository extends JpaRepository<SeatCategory, Integer> {
}
