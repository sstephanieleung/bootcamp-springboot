package com.vtxlab.bootcamp.bootcampsbcalculator.model.exception;

import lombok.Getter;

@Getter
public enum SysCode {

    OK(100, "Input Validated."),
    // Runtime Exception
    ILLEGAL_ARGUMENT_EXCEPTION(90, "Invalid Operation Input."),
    NUMBER_FORMAT_EXCEPTION(91, "Invalid Number Input."),
    ARITHMETIC_EXCEPTION_DIV_BY_ZERO(92, "Invalid Input: Zero cannot be dividor."),
    NPE(93,"Empty Field Detected."),
    GENERAL_EXCEPTION(99, "General Exception.")
    ;

    private int code;

    private String message;

    private SysCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
