package com.example.demo.repository;

import com.example.demo.domain.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaStageRepository extends JpaRepository<Stage, Integer> {
}
