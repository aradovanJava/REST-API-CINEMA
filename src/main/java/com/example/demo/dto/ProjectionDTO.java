package com.example.demo.dto;

import com.example.demo.domain.Genre;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ProjectionDTO {
    private String name;

    private String director;

    @JsonFormat(pattern="dd.MM.yyyy. HH:mm:ss")
    private LocalDateTime dateTime;

    private Short duration;

    private Genre genre;
}
