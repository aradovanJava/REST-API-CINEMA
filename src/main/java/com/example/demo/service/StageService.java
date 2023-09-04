package com.example.demo.service;

import com.example.demo.domain.Seat;
import com.example.demo.domain.Stage;

import java.util.List;
import java.util.Optional;

public interface StageService {

    List<Stage> getAllStages();

    Optional<Stage> getStageById(Integer id);

    void saveNewStage(Stage newStage);

    Optional<Stage> updateStage(Stage updatedStage, Integer id);

    void deleteStage(Integer id);

}
