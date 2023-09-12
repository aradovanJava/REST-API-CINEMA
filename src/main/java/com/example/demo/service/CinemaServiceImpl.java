package com.example.demo.service;

import com.example.demo.domain.Cinema;
import com.example.demo.repository.JpaCinemaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CinemaServiceImpl implements CinemaService {

    private JpaCinemaRepository cinemaRepository;
    @Override
    public List<Cinema> findAll() {
        return cinemaRepository.findAll();
    }

    @Override
    public Optional<Cinema> findById(Integer id) {
        return cinemaRepository.findById(id);
    }

    @Override
    public void save(Cinema newCinema) {
        cinemaRepository.save(newCinema);
    }

    @Override
    public Optional<Cinema> update(Cinema cinemaToUpdate, Integer id) {

        Optional<Cinema> managedCinemaBean = cinemaRepository.findById(id);

        if(managedCinemaBean.isPresent()) {
            Cinema updatedCinema = managedCinemaBean.get();
            updatedCinema.setAddress(cinemaToUpdate.getAddress());
            updatedCinema.setStageList(cinemaToUpdate.getStageList());
            updatedCinema.setName(cinemaToUpdate.getName());
            Cinema newUpdatedCinema = cinemaRepository.save(updatedCinema);
            return Optional.of(newUpdatedCinema);
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteById(Integer id) {
        cinemaRepository.deleteById(id);
    }

    @Override
    public List<Cinema> findByEmployee(Integer employeeId) {
        return cinemaRepository.findByEmployee(employeeId);
    }


}
