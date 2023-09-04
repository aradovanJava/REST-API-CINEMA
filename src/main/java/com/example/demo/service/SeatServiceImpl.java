package com.example.demo.service;

import com.example.demo.domain.Seat;
import com.example.demo.repository.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SeatServiceImpl implements SeatService {

    private SeatRepository seatRepository;
    @Override
    public List<Seat> getAllSeats() {
        return seatRepository.getAllSeats();
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
