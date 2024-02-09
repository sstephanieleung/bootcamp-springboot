package com.vtxlab.bootcamp.bootcampsbcalculator.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.bootcamp.bootcampsbcalculator.controller.CalculatorOperation;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.ApiResp;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.Calculation;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.dto.CalculationDTO;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.exception.SysCode;
import com.vtxlab.bootcamp.bootcampsbcalculator.service.CalculatorService;

@RestController
@RequestMapping(value = "/api/v1")

public class CalculatorController implements CalculatorOperation {

    @Autowired
    private CalculatorService cs;

    @Override
    public ApiResp<CalculationDTO> getByRequestParam(String x, String y, String operation) {

        CalculationDTO calculationDTO = CalculationDTO.builder().x(x).y(y).operation(operation)
                .result(String.valueOf(cs.getCalculation(x, y, operation)))
                .build();
        return ApiResp.<CalculationDTO>builder()
                .code(SysCode.OK.getCode())
                .message(SysCode.OK.getMessage())
                .data(calculationDTO)
                .build();
    }

    @Override
    public ApiResp<CalculationDTO> postByRequestBody(Calculation json) {
        CalculationDTO calculationDTO = CalculationDTO.builder().x(json.getX()).y(json.getY()).operation(json.getOperation())
                .result(String.valueOf(cs.getCalculation(json.getX(), json.getY(), json.getOperation())))
                .build();
        return ApiResp.<CalculationDTO>builder()
                .code(SysCode.OK.getCode())
                .message(SysCode.OK.getMessage())
                .data(calculationDTO)
                .build();
    }

    @Override
    public ApiResp<CalculationDTO> getByPathVariable(String x, String y, String operation) {
        CalculationDTO calculationDTO = CalculationDTO.builder().x(x).y(y).operation(operation)
                .result(String.valueOf(cs.getCalculation(x, y, operation)))
                .build();
        return ApiResp.<CalculationDTO>builder()
                .code(SysCode.OK.getCode())
                .message(SysCode.OK.getMessage())
                .data(calculationDTO)
                .build();
    }

    // @Override
    // public ResponseEntity<CalculationDTO> getByRequestParam(String x, String y,
    // String operation) {
    // CalculationDTO calculationDTO = this.getCalculation(x, y, operation);
    // return ResponseEntity.ok(calculationDTO);
    // }

    // @Override
    // public ResponseEntity<CalculationDTO> postByRequestBody(Calculation json) {
    // CalculationDTO calculationDTO = this.getCalculation(json.getX(), json.getY(),
    // json.getOperation());
    // return ResponseEntity.ok(calculationDTO);
    // }

    // @Override
    // public ResponseEntity<CalculationDTO> getByPathVariable(String x, String y,
    // String operation) {
    // CalculationDTO calculationDTO = this.getCalculation(x, y, operation);
    // return ResponseEntity.ok(calculationDTO);
    // }
}
