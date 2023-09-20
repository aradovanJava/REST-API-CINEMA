package com.example.demo.service;

import com.example.demo.domain.Projection;
import com.example.demo.dto.ProjectionDTO;

import java.util.List;

public interface ProjectionService {
    List<ProjectionDTO> findAll();

    ProjectionDTO saveNewProjection(ProjectionDTO projection);
}
