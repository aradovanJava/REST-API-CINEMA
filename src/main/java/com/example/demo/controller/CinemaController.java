package com.example.demo.controller;

import com.example.demo.service.CinemaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Repeatable;

@RestController
@AllArgsConstructor
@RequestMapping("cinema")
public class CinemaController {

    private CinemaService cinemaService;

    @GetMapping
    public ResponseEntity<?> getCinemas() {
        return ResponseEntity.status(HttpStatus.OK).body(cinemaService.findAll());
    }

    @GetMapping("/workforce/{employeeId}")
    public ResponseEntity<?> getCinemasByEmployeeId(@PathVariable Integer employeeId) {
        return ResponseEntity.status(HttpStatus.OK).body(cinemaService.findByEmployee(employeeId));
    }

}
