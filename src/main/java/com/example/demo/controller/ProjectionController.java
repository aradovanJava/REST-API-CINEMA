package com.example.demo.controller;

import com.example.demo.dto.ProjectionDTO;
import com.example.demo.service.ProjectionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("cinema")
public class ProjectionController {

    private ProjectionService projectionService;

    @GetMapping("/projection")
    public ResponseEntity<List<ProjectionDTO>> fetchAllProjections() {
        List<ProjectionDTO> allProjection = projectionService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(allProjection);
    }

    @PostMapping("/projection")
    public ResponseEntity<?> saveProjection(@RequestBody ProjectionDTO projectionDTO) {
        projectionService.saveNewProjection(projectionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Projection created");
    }

}
