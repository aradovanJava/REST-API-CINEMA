package com.example.demo.service;

import com.example.demo.domain.Projection;
import com.example.demo.dto.ProjectionDTO;
import com.example.demo.dtomapper.ProjectionDTOMapper;
import com.example.demo.repository.JpaProjectionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectionServiceImpl implements ProjectionService {

    private JpaProjectionRepository jpaProjectionRepository;

    private ProjectionDTOMapper mapper;
    @Override
    public List<ProjectionDTO> findAll() {
        return jpaProjectionRepository.findAll().stream()
                .map(mapper::toDto).toList();
    }

    @Override
    public ProjectionDTO saveNewProjection(ProjectionDTO projectionDTO) {
        return mapper.toDto(jpaProjectionRepository.save(mapper.toProjection(projectionDTO)));
    }
}
