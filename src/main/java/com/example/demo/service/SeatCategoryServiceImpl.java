package com.example.demo.service;

import com.example.demo.domain.SeatCategory;
import com.example.demo.repository.SeatCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SeatCategoryServiceImpl implements SeatCategoryService {

    private SeatCategoryRepository seatCategoryRepository;
    @Override
    public List<SeatCategory> findAll() {
        return seatCategoryRepository.findAll();
    }

    @Override
    public SeatCategory findById(Integer id) {
        return seatCategoryRepository.findById(id);
    }

    @Override
    public void save(SeatCategory newSeatCategory) {
        seatCategoryRepository.save(newSeatCategory);
    }

    @Override
    public SeatCategory update(SeatCategory seatCategory, Integer originalSeatCategoryId) {
        return seatCategoryRepository.update(seatCategory, originalSeatCategoryId);
    }

    @Override
    public void delete(SeatCategory seat) {
        seatCategoryRepository.delete(seat);
    }
}
