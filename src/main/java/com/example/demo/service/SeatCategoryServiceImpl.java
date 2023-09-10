package com.example.demo.service;

import com.example.demo.domain.SeatCategory;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.repository.JpaSeatCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SeatCategoryServiceImpl implements SeatCategoryService {

    //private SeatCategoryRepository seatCategoryRepository;
    private JpaSeatCategoryRepository seatCategoryRepository;
    @Override
    public List<SeatCategory> findAll() {
        return seatCategoryRepository.findAll();
    }

    @Override
    public Optional<SeatCategory> findById(Integer id) {
        return seatCategoryRepository.findById(id);
    }

    @Override
    public void save(SeatCategory newSeatCategory) {
        seatCategoryRepository.save(newSeatCategory);
    }

    @Override
    public SeatCategory update(SeatCategory seatCategoryForUpdate, Integer originalSeatCategoryId) {
        Optional<SeatCategory> managedSeatCategoryOptional =
                seatCategoryRepository.findById(originalSeatCategoryId);

        if(managedSeatCategoryOptional.isPresent()) {
            SeatCategory managedSeatCategory = managedSeatCategoryOptional.get();
            managedSeatCategory.setName(seatCategoryForUpdate.getName());
            managedSeatCategory.setDescription(seatCategoryForUpdate.getDescription());
            SeatCategory savedSeatCategory = seatCategoryRepository.save(managedSeatCategory);
            return savedSeatCategory;
        }
        else {
            throw new EntityNotFoundException("There is no Seat object for ID = '" + originalSeatCategoryId + "'");
        }
    }

    @Override
    public void delete(SeatCategory seat) {
        seatCategoryRepository.delete(seat);
    }
}
