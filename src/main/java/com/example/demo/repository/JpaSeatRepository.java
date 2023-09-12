package com.example.demo.repository;

import com.example.demo.domain.Seat;
import com.example.demo.domain.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaSeatRepository extends JpaRepository<Seat, Integer> {
    @Query("SELECT s from Seat s WHERE s.stage.id = :stageId")
    List<Seat> findByStageId(@Param("stageId") Integer stageId);

}
