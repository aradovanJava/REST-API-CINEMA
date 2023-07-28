package com.example.demo.repository;

import com.example.demo.domain.Seat;
import com.example.demo.domain.Stage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class FileStageRepository implements StageRepository {

    private static final Integer NUMBER_OF_STAGE_ROWS = 3;

    private SeatRepository seatRepository;

    private static final String STAGE_FILE_LOCATION = "dat/stages.txt";
    @Override
    public List<Stage> getAllStages() {
        List<Stage> stageList = new ArrayList<>();

        Path stageFilePath = Path.of(STAGE_FILE_LOCATION);

        List<String> lines = null;
        try {
            lines = Files.readAllLines(stageFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for(int i = 0; i < lines.size()/NUMBER_OF_STAGE_ROWS; i++) {
            String idString = lines.get(i * NUMBER_OF_STAGE_ROWS);
            Long id = Long.parseLong(idString);
            String stageName = lines.get(i * NUMBER_OF_STAGE_ROWS + 1);
            String seatsGroup = lines.get(i * NUMBER_OF_STAGE_ROWS + 2);
            String[] seatsIds = seatsGroup.split("\\s+");

            List<Seat> seatList = new ArrayList<>();

            for(String seatIdString : seatsIds) {
                Long seatId = Long.parseLong(seatIdString);
                Optional<Seat> seatOptional = seatRepository.getSeatById(seatId);

                if(seatOptional.isPresent()) {
                    seatList.add(seatOptional.get());
                }
            }

            Stage newStage = new Stage(id, stageName, seatList);
            stageList.add(newStage);
        }

        return stageList;
    }

    @Override
    public Optional<Stage> getStageById(Long id) {
        return getAllStages().stream().filter(s -> s.getId().equals(id)).findFirst();
    }

    @Override
    public void saveNewStage(Stage newStage) {
        List<Stage> allStages = getAllStages();
        Long highestId = allStages.stream()
                .map(s -> s.getId())
                .max((id1, id2) -> id1.compareTo(id2))
                .get();

        newStage.setId(highestId + 1);
        allStages.add(newStage);

        saveAllStagesToFile(allStages);
    }

    private static void saveAllStagesToFile(List<Stage> allStages) {
        Path stagesFilePath = Path.of(STAGE_FILE_LOCATION);

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(stagesFilePath.toFile(), false))) {

            for(Stage stage : allStages) {
                String seatId = String.valueOf(stage.getId());
                String stageName = stage.getName();
                StringBuilder sbStageIds = new StringBuilder();

                for(Seat seat : stage.getSeatList()) {
                    sbStageIds.append(seat.getId()).append(" ");
                }

                bw.write(seatId);
                bw.newLine();
                bw.write(stageName);
                bw.newLine();
                bw.write(sbStageIds.toString());
                bw.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Stage> updateStage(Stage updatedStage, Long id) {
        List<Stage> allStages = getAllStages();

        Optional updatedStageOptional = Optional.empty();

        for(Stage stage : allStages) {
            if(stage.getId().equals(id)) {
                stage.setName(updatedStage.getName());
                stage.setSeatList(updatedStage.getSeatList());
                updatedStageOptional = Optional.of(stage);
                break;
            }
        }

        if(updatedStageOptional.isPresent()) {
            saveAllStagesToFile(allStages);
        }

        return updatedStageOptional;
    }

    @Override
    public void deleteStage(Long id) {
        List<Stage> allStages = getAllStages();

        List<Stage> listWithoutTheDeletedStage =
                allStages.stream().filter(s -> !s.getId().equals(id))
                        .collect(Collectors.toList());

        if(listWithoutTheDeletedStage.size() != allStages.size()) {
            saveAllStagesToFile(listWithoutTheDeletedStage);
        }
    }
}
