package com.vtxlab.bootcamp.bootcampsbcalculator.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtxlab.bootcamp.bootcampsbcalculator.controller.impl.CalculatorController;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.ApiResp;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.Calculation;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.dto.CalculationDTO;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.exception.SysCode;
import com.vtxlab.bootcamp.bootcampsbcalculator.service.CalculatorService;

@WebMvcTest(CalculatorController.class)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService cs;

    
    @Test
    void testGetRequestByPathVariable() throws Exception {

        CalculationDTO calculationDTOMockReturn = CalculationDTO.builder()
                .x("10").y("3").operation("div").result("3.33333")
                .build();
        ApiResp<CalculationDTO> apiRespMockReturn = ApiResp.<CalculationDTO>builder()
                .code(SysCode.OK.getCode())
                .message(SysCode.OK.getMessage())
                .data(calculationDTOMockReturn)
                .build();

        // When
        Mockito.when(cs.getCalculation("10", "3", "div")).thenReturn(3.33333d);

        // Assert
        mockMvc.perform(get("/api/v1/{x}/{y}/{operation}", "10", "3", "div"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.code").value(apiRespMockReturn.getCode()))
                .andExpect(jsonPath("$.message").value(apiRespMockReturn.getMessage()))
                .andExpect(jsonPath("$.data.x").value(calculationDTOMockReturn.getX()))
                .andExpect(jsonPath("$.data.y").value(calculationDTOMockReturn.getY()))
                .andExpect(jsonPath("$.data.result").value(calculationDTOMockReturn.getResult()))
                .andExpect(jsonPath("$.data.operation").value(calculationDTOMockReturn.getOperation()));
    }

    @Test
    void testRequestGetByRequestParam() {

    }

    @Test
    void testRequestPostByRequestBody() throws Exception {
        Calculation calculationRequest = Calculation.builder()
                .x("10").y("3").operation("div").build();

        CalculationDTO calculationDTOMockReturn = CalculationDTO.builder()
                .x("10").y("3").operation("div")
                .result("3.33333")
                .build();

        ApiResp<CalculationDTO> apiRespMockReturn = ApiResp.<CalculationDTO>builder()
                .code(SysCode.OK.getCode())
                .message(SysCode.OK.getMessage())
                .data(calculationDTOMockReturn)
                .build();

        Mockito.when(cs.getCalculation("10", "3", "div")).thenReturn(3.33333d);
        
        mockMvc.perform(post("/api/v1/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(calculationRequest)))
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$.code").value(apiRespMockReturn.getCode()),
                        jsonPath("$.message").value(apiRespMockReturn.getMessage()),
                        jsonPath("$.data.x").value(apiRespMockReturn.getData().getX()),
                        jsonPath("$.data.y").value(apiRespMockReturn.getData().getY()),
                        jsonPath("$.data.result").value(apiRespMockReturn.getData().getResult()),
                        jsonPath("$.data.operation").value(apiRespMockReturn.getData().getOperation()));

    }
}
