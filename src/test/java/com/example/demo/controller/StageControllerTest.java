package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StageControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void shouldReturnAllStagesFromFile() throws Exception {
        this.mockMvc.perform(get("/cinema/stage"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(4)));
    }

    @Test
    public void shouldReturnStageById() throws Exception {

        final String SEAT_ID = "1";
        final String name = "Dvorana A";
        final Integer numberOfSeats = 4;

        this.mockMvc.perform(get("/cinema/stage/" + SEAT_ID))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value(name));
    }

    @Test
    public void shouldReturnCorrectNumberOfSeats() throws Exception {

        final String STAGE_ID = "1";
        final Integer numberOfSeats = 4;

        this.mockMvc.perform(get("/cinema/stage/" + STAGE_ID))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.seatList", hasSize(numberOfSeats)));
    }

    @Test
    public void shouldReturn204IfSeatIdDoesNotExist() throws Exception {

        final String STAGE_ID = "1111111111";

        this.mockMvc.perform(get("/cinema/stage/" + STAGE_ID))
                .andExpect(status().isNoContent());
    }
}
