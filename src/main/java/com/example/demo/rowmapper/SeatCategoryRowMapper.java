package com.example.demo.rowmapper;

import com.example.demo.domain.SeatCategory;
import com.example.demo.repository.SeatCategoryRepository;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SeatCategoryRowMapper implements RowMapper<SeatCategory> {
    @Override
    public SeatCategory mapRow(ResultSet rs, int rowNum) throws SQLException {

        Integer id = rs.getInt("ID");
        String name = rs.getString("NAME");
        String description = rs.getString("DESCRIPTION");

        SeatCategory newSeatCategory = new SeatCategory(id, name, description);

        return newSeatCategory;
    }
}
