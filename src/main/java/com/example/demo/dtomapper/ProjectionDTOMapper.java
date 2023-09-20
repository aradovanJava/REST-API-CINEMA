package com.example.demo.dtomapper;

import com.example.demo.domain.Film;
import com.example.demo.domain.Projection;
import com.example.demo.domain.Stage;
import com.example.demo.dto.ProjectionDTO;
import com.example.demo.repository.JpaFilmRepository;
import com.example.demo.repository.JpaSeatRepository;
import com.example.demo.repository.JpaStageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ProjectionDTOMapper {

    private JpaFilmRepository jpaFilmRepository;

    private JpaStageRepository jpaStageRepository;

    public ProjectionDTO toDto(final Projection projection) {
        return new ProjectionDTO(projection.getFilm().getName(), projection.getFilm().getDirector(),
                projection.getDateAndTime(), projection.getFilm().getDuration(), projection.getFilm().getGenre());
    }

    public Projection toProjection(final ProjectionDTO projectionDTO) {
        Projection newProjection = new Projection();
        newProjection.setDateAndTime(projectionDTO.getDateTime());

        Optional<Film> filmOptional = jpaFilmRepository.findById(1);

        newProjection.setFilm(filmOptional.get());
        /*
        newProjection.getFilm().setId(1);
        newProjection.getFilm().setName(projectionDTO.getName());
        newProjection.getFilm().setDirector(projectionDTO.getDirector());
        newProjection.getFilm().setDuration(projectionDTO.getDuration());
        newProjection.getFilm().setGenre(projectionDTO.getGenre());
         */
        //dohvat iz baze

        Optional<Stage> stageOptional = jpaStageRepository.findById(1);

        newProjection.setStage(stageOptional.get());
        return newProjection;
    }


}
