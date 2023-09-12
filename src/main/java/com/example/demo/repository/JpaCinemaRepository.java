package com.example.demo.repository;

import com.example.demo.domain.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.lang.reflect.Parameter;
import java.util.List;

public interface JpaCinemaRepository extends JpaRepository<Cinema, Integer> {

    @Query(value = """
            SELECT * FROM cinema c JOIN cinema_employee ce
            ON c.id = ce.cinema_id
            WHERE ce.employee_id = :employeeId""",
            nativeQuery=true)
    List<Cinema> findByEmployee(@Param("employeeId") Integer employeeId);
}
