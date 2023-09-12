package com.example.demo.rowmapper;

import com.example.demo.domain.*;
import com.example.demo.repository.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@AllArgsConstructor
public class SeatRowMapper implements RowMapper<Seat>  {

    private SeatRepository seatRepository;

    @Override
    public Seat mapRow(ResultSet rs, int rowNum) throws SQLException {

        Integer seatId = rs.getInt("SEAT ID");
        String rowName = rs.getString("ROW_NAME");
        Integer position = rs.getInt("POSITION");
        Integer seatCategoryId = rs.getInt("SEAT CATEGORY ID");
        String seatCategoryName = rs.getString("SEAT CATEGORY NAME");
        String seatCategoryDescription = rs.getString("SEAT CATEGORY DESCRIPTION");
        Integer stageId = rs.getInt("STAGE ID");
        String stageName = rs.getString("STAGE NAME");
        String stageDescription = rs.getString("STAGE DESCRIPTION");
        Integer cinemaId = rs.getInt("CINEMA ID");
        String cinemaName = rs.getString("CINEMA NAME");
        String cinemaAddress = rs.getString("ADDRESS");

        Cinema cinema = new Cinema(cinemaId, cinemaName, cinemaAddress);
        SeatCategory seatCategory  = new SeatCategory(seatCategoryId, seatCategoryName, seatCategoryDescription);
        Seat seat = new Seat(seatId, RowName.valueOf(rowName), position, seatCategory);

        //stage.setSeatList(seatRepository.getAllSeatsByStage(stage));

        return seat;
    }
}
