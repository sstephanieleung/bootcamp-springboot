package com.vtxlab.bootcamp.bootcampsbcalculator.infra;

import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vtxlab.bootcamp.bootcampsbcalculator.model.exception.BusinessException;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.exception.SysCode;

@RestControllerAdvice
public class GlobalExceptionHandler {

    

    @ExceptionHandler(ArithmeticException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)  //HTTP 400
    public ApiResp<Void> handleException(ArithmeticException e) {
        return ApiResp.<Void>builder()//
                .code(SysCode.ARITHMETIC_EXCEPTION_DIV_BY_ZERO.getCode()) //
                .message(SysCode.ARITHMETIC_EXCEPTION_DIV_BY_ZERO.getMessage())//
                .data(null)
                .build();
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)  //HTTP 400
    public ApiResp<Void> handleException(BusinessException e) {
        return ApiResp.<Void>builder()//
                .code(e.getCode()) //
                .message(e.getMessage())//
                .data(null)
                .build();

    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)  //HTTP 400
    public ApiResp<Void> handleException(NumberFormatException e) {
        return ApiResp.<Void>builder()//
                .code(SysCode.NUMBER_FORMAT_EXCEPTION.getCode()) //
                .message(SysCode.NUMBER_FORMAT_EXCEPTION.getMessage())//
                .build();
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)  //HTTP 400
    public ApiResp<Void> handleException(NullPointerException e) {
        return ApiResp.<Void>builder()//
                .code(SysCode.NPE.getCode()) //
                .message(SysCode.NPE.getMessage())//
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiResp<Void> handleException(Exception e){
        return ApiResp.<Void>builder()
            .code(SysCode.GENERAL_EXCEPTION.getCode())
            .message(SysCode.GENERAL_EXCEPTION.getMessage())
            .build();
    }
    

//     @ExceptionHandler(NumberFormatException.class)
//     public ResponseEntity<ApiResp<Void>> handleException(NumberFormatException e) {
//         return ResponseEntity.badRequest().body(ApiResp.<Void>builder()//
//                 .code(SysCode.NUMBER_FORMAT_EXCEPTION.getCode()) //
//                 .message(SysCode.NUMBER_FORMAT_EXCEPTION.getMessage())//
//                 .build());
//     }

    // @ExceptionHandler(NumberFormatException.class)
    // @ResponseBody
    // public BusinessException handleNumberFormatException(NumberFormatException
    // e){
    // return new BusinessException(CustomError.CODE9);
    // }

}
