package com.example.demo.repository;

import com.example.demo.domain.Seat;
import com.example.demo.domain.Stage;

import java.util.List;
import java.util.Optional;

public interface SeatRepository {
    List<Seat> getAllSeats();

    Optional<Seat> getSeatById(Integer id);

    void saveNewSeat(Seat newSeat);

    Optional<Seat> updateSeat(Seat updatedSeat, Integer id);

    void deleteSeat(Integer id);

    List<Seat> getAllSeatsByStage(Stage stage);
}
