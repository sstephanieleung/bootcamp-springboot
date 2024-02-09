package com.vtxlab.bootcamp.bootcampsbcalculator.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Calculation {
    
    private String x;

    private String y;

    private String operation;

}
