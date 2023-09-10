package com.example.demo.service;

import com.example.demo.domain.Seat;
import com.example.demo.repository.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SeatServiceImpl implements SeatService {

    @Qualifier("jdbcSeatRepository")
    private SeatRepository seatRepository;

    @Override
    public List<Seat> getAllSeats() {

        List<Seat> allSeats = seatRepository.getAllSeats();

        for(Seat seat : allSeats) {
            seat.getStage().setSeatList(seatRepository.getAllSeatsByStage(seat.getStage()));
        }

        return allSeats;
    }

    @Override
    public Optional<Seat> getSeatById(Integer id) {
        return seatRepository.getSeatById(id);
    }

    @Override
    public void saveNewSeat(Seat newSeat) {
        seatRepository.saveNewSeat(newSeat);
    }

    @Override
    public Optional<Seat> updateSeat(Seat updatedSeat, Integer id) {
        return seatRepository.updateSeat(updatedSeat, id);
    }

    @Override
    public void deleteSeat(Integer id) {
        seatRepository.deleteSeat(id);
    }


}
