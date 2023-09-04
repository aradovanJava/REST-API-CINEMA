package com.example.demo.repository;

import com.example.demo.domain.SeatCategory;
import com.example.demo.rowmapper.SeatCategoryRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
@AllArgsConstructor
public class JdbcSeatCategoryRepository implements SeatCategoryRepository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<SeatCategory> findAll() {
        List<SeatCategory> seatCategoryList = jdbcTemplate.query("SELECT * FROM SEAT_CATEGORY", new SeatCategoryRowMapper());
        return seatCategoryList;
    }

    @Override
    public SeatCategory findById(Integer id) {
        return null;
    }
}
