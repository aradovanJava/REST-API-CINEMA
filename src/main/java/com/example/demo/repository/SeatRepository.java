package com.example.demo.repository;

import com.example.demo.domain.Seat;

import java.util.List;
import java.util.Optional;

public interface SeatRepository {
    List<Seat> getAllSeats();

    Optional<Seat> getSeatById(Integer id);

    void saveNewSeat(Seat newSeat);

    Optional<Seat> updateSeat(Seat updatedSeat, Integer id);

    void deleteSeat(Integer id);
}
