package com.vtxlab.bootcamp.bootcampsbcalculator.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.vtxlab.bootcamp.bootcampsbcalculator.infra.ApiResp;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.CalOperation;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.dto.CalculationDTO;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.exception.SysCode;
import com.vtxlab.bootcamp.bootcampsbcalculator.service.CalculatorService;
import com.vtxlab.bootcamp.bootcampsbcalculator.service.impl.CalculatorServiceImpl;

@WebMvcTest(CalculatorServiceImpl.class)
@ExtendWith(MockitoExtension.class)
public class OperationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService cs;

    @Test
    void testAdd() {

        CalculationDTO calculationDTOMockReturn = CalculationDTO.builder()
                .x("10").y("3").operation("ad").result("13.0")
                .build();

        Mockito.when(Double.parseDouble("10")).thenReturn(10.0d);
        Mockito.when(Double.parseDouble("3")).thenReturn(3.0d);

        mockMvc.perform(get("/api/v1/{x}/{y}/{operation}", "10", "3", "add"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.x").value(calculationDTOMockReturn.getX()))
                .andExpect(jsonPath("$.data.y").value(calculationDTOMockReturn.getY()))
                .andExpect(jsonPath("$.data.result").value(calculationDTOMockReturn.getResult()));
                .andExpect(jsonPath("$.data.operation").value(calculationDTOMockReturn.getOperation()));

    }

    @Test
    void testNumberFormatException() {

    }
}
