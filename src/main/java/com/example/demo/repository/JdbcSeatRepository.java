package com.example.demo.repository;

import com.example.demo.domain.Seat;
import com.example.demo.domain.Stage;
import com.example.demo.rowmapper.SeatRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Primary
@Repository
@AllArgsConstructor
public class JdbcSeatRepository implements SeatRepository {

    private static final String SQL_GET_ALL_SEATS = "SELECT S.ID AS 'SEAT ID', ROW_NAME, POSITION,\n" +
            "SK.ID AS 'SEAT CATEGORY ID', SK.NAME 'SEAT CATEGORY NAME', SK.DESCRIPTION 'SEAT CATEGORY DESCRIPTION',\n" +
            "ST.ID AS 'STAGE ID', ST.NAME 'STAGE NAME', ST.DESCRIPTION 'STAGE DESCRIPTION',\n" +
            "C.ID AS 'CINEMA ID', C.NAME 'CINEMA NAME', C.ADDRESS\n" +
            "FROM SEAT S JOIN SEAT_CATEGORY SK \n" +
            "ON S.CATEGORY_ID = SK.ID\n" +
            "JOIN STAGE ST \n" +
            "ON S.STAGE_ID = ST.ID\n" +
            "JOIN CINEMA C\n" +
            "ON C.ID = ST.CINEMA_ID";

    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Seat> getAllSeats() {
        return jdbcTemplate.query(SQL_GET_ALL_SEATS, new SeatRowMapper(this));
    }

    @Override
    public Optional<Seat> getSeatById(Integer id) {

        String sqlGetSeatById = SQL_GET_ALL_SEATS + " WHERE S.ID = ?";

        Optional<Seat> optionalSeat = Optional.empty();

        try {
            optionalSeat = Optional.of(jdbcTemplate.queryForObject(sqlGetSeatById, new SeatRowMapper(this), id));
        }
        catch(EmptyResultDataAccessException ex) {
            return optionalSeat;
        }

       return optionalSeat;
    }

    @Override
    public void saveNewSeat(Seat newSeat) {
        jdbcTemplate.update("INSERT INTO SEAT(ROW_NAME, POSITION, CATEGORY_ID)\n" +
                "VALUES(?, ?, ?, ?)", newSeat.getRowName(), newSeat.getPositionInRow(), newSeat.getSeatCategory().getId());
    }

    @Override
    public Optional<Seat> updateSeat(Seat updatedSeat, Integer id) {

        Integer updateResult = jdbcTemplate.update("UPDATE SEAT SET ROW_NAME = ?, POSITION = ?, CATEGORY_ID = ?, STAGE_ID = ? WHERE ID = ?",
                updatedSeat.getRowName(), updatedSeat.getPositionInRow(), updatedSeat.getSeatCategory().getId(), id);

        if(updateResult == 0) {
            return Optional.empty();
        }
        else {
            return getSeatById(id);
        }
    }

    @Override
    public void deleteSeat(Integer id) {
        jdbcTemplate.update("DELETE FROM SEAT WHERE ID = ?", id);
    }

    @Override
    public List<Seat> getAllSeatsByStage(Stage stage) {
        String sql = SQL_GET_ALL_SEATS + " WHERE S.STAGE_ID = ?";
        return jdbcTemplate.query(sql, new SeatRowMapper(this), stage.getId());
    }
}
