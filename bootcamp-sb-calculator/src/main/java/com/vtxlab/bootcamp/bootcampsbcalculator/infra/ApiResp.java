package com.vtxlab.bootcamp.bootcampsbcalculator.infra;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResp<T> {
    private int code;
    private String message;
    private T data;

}
