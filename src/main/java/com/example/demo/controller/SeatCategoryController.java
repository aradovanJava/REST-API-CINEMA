package com.example.demo.controller;

import com.example.demo.domain.Seat;
import com.example.demo.domain.SeatCategory;
import com.example.demo.service.SeatCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("cinema/seat-category")
@AllArgsConstructor
public class SeatCategoryController {

    private SeatCategoryService seatCategoryService;

    @GetMapping
    public ResponseEntity<?> getSeatCategories() {
        return ResponseEntity.status(HttpStatus.OK).body(seatCategoryService.findAll());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getSeatCategoryById(@PathVariable Integer id) {
        SeatCategory seatCategory = seatCategoryService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(seatCategory);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveNewSeatCategory(@RequestBody SeatCategory newSeatCategory) {
        seatCategoryService.save(newSeatCategory);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> updateNewSeatCategory(@RequestBody SeatCategory seatCategoryWithNewValues, @PathVariable Integer id) {
        SeatCategory updatedSeatCategory = seatCategoryService.update(seatCategoryWithNewValues, id);
        return ResponseEntity.status(HttpStatus.OK).body(updatedSeatCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSeatCategoryById(@PathVariable Integer id) {
        seatCategoryService.delete(seatCategoryService.findById(id));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
