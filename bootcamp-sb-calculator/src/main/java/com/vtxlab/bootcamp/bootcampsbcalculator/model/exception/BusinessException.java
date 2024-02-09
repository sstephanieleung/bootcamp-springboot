package com.vtxlab.bootcamp.bootcampsbcalculator.model.exception;

import lombok.Getter;

@Getter
public class BusinessException  extends RuntimeException{

    private int code;
    
    public BusinessException(SysCode code){
        super(code.getMessage());
        this.code = code.getCode();
    }
}
