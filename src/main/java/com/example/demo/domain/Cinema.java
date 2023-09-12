package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode
public class Cinema extends BaseEntity {

    private String name;
    private String address;

    @OneToMany(mappedBy="cinema")
    List<Stage> stageList;

    @ManyToMany
    @JoinTable(
            name = "cinema_employee",
            joinColumns = @JoinColumn(name = "cinema_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    List<Employee> employees;

    public Cinema(Integer id, String name, String address) {
        super(id);
        this.name = name;
        this.address = address;
    }

    /*
    @Id
    public Integer getId() {
        return super.getId();
    }
     */

}
