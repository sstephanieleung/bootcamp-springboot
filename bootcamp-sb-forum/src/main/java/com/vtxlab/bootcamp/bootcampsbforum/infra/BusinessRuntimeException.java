package com.vtxlab.bootcamp.bootcampsbforum.infra;

import lombok.Getter;

@Getter
public class BusinessRuntimeException extends RuntimeException{
    
    private String code;

    public BusinessRuntimeException(Syscode syscode){
        super(syscode.getMessage());
        this.code = syscode.getCode();
    }
}
