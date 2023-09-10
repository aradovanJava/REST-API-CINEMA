package com.example.demo.repository;

import com.example.demo.domain.Stage;

import java.util.List;
import java.util.Optional;

public class JdbcStageRepository implements StageRepository {
    @Override
    public List<Stage> getAllStages() {
        return null;
    }

    @Override
    public Optional<Stage> getStageById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void saveNewStage(Stage newStage) {

    }

    @Override
    public Optional<Stage> updateStage(Stage updatedStage, Integer id) {
        return Optional.empty();
    }

    @Override
    public void deleteStage(Integer id) {

    }
}
