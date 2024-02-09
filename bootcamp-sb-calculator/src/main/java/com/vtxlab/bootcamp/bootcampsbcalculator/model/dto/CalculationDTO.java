package com.vtxlab.bootcamp.bootcampsbcalculator.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CalculationDTO {
    
    private String x;

    private String y;

    private String operation;

    private String result;

    // private Integer code;

    // private String message;

}
