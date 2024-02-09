package com.vtxlab.bootcamp.bootcampsbcalculator.controller;

// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.vtxlab.bootcamp.bootcampsbcalculator.infra.ApiResp;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.Calculation;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.dto.CalculationDTO;

public interface CalculatorOperation {

        @GetMapping(value = "/")
        ApiResp<CalculationDTO> getByRequestParam(@RequestParam(name = "x") String x,
                        @RequestParam(name = "y") String y,
                        @RequestParam(name = "operation") String operation);

        @PostMapping(value = "/")
        ApiResp<CalculationDTO> postByRequestBody(@RequestBody Calculation json);

        @GetMapping(value = "/{x}/{y}/{operation}")
        ApiResp<CalculationDTO> getByPathVariable(@PathVariable(value = "x") String x,
                        @PathVariable String y, @PathVariable String operation);

        // @GetMapping(value = "/")
        // ResponseEntity<CalculationDTO> getByRequestParam(@RequestParam(name = "x") String x,
        //                 @RequestParam(name = "y") String y,
        //                 @RequestParam(name = "operation") String operation);

        // @PostMapping(value = "/")
        // ResponseEntity<CalculationDTO> postByRequestBody(@RequestBody Calculation json);

        // @GetMapping(value = "/{x}/{y}/{operation}")
        // ResponseEntity<CalculationDTO> getByPathVariable(@PathVariable(value = "x") String x,
        //                 @PathVariable String y, @PathVariable String operation);

        // @GetMapping(value = "/x/{x}/y/{y}/sub")
        // double subtraction(@PathVariable double x, @PathVariable double y);

        // @GetMapping(value = "/x/{x}/y/{y}/mul")
        // double multiplication(@PathVariable double x, @PathVariable double y);

        // @GetMapping(value = "/x/{x}/y/{y}/div")
        // double division(@PathVariable double x, @PathVariable double y);

        // @GetMapping(value = "/x/{x}/y/{y}/q")
        // int quotient(@PathVariable int x, @PathVariable int y);
}
