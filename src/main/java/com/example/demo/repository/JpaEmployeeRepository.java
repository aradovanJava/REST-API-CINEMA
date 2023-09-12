package com.example.demo.repository;

import com.example.demo.domain.Cinema;
import com.example.demo.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "SELECT * FROM cinema c JOIN cinema_employee ce " +
            "ON c.id = ce.cinema_id JOIN employee e ON e.id = ce.employee_id "
            + "WHERE c.id = :cinemaId ",
            nativeQuery=true)
    List<Employee> findByCinema(@Param("cinemaId") Integer cinemaId);
}
