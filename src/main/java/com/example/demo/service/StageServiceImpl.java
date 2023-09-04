package com.example.demo.service;

import com.example.demo.domain.Stage;
import com.example.demo.repository.SeatRepository;
import com.example.demo.repository.StageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StageServiceImpl implements StageService {

    private StageRepository stageRepository;
    @Override
    public List<Stage> getAllStages() {
        return stageRepository.getAllStages();
    }

    @Override
    public Optional<Stage> getStageById(Integer id) {
        return stageRepository.getStageById(id);
    }

    @Override
    public void saveNewStage(Stage newStage) {
        stageRepository.saveNewStage(newStage);
    }

    @Override
    public Optional<Stage> updateStage(Stage updatedStage, Integer id) {
        return stageRepository.updateStage(updatedStage, id);
    }

    @Override
    public void deleteStage(Integer id) {
        stageRepository.deleteStage(id);
    }
}
