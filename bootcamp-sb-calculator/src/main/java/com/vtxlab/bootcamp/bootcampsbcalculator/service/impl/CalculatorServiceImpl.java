package com.vtxlab.bootcamp.bootcampsbcalculator.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.vtxlab.bootcamp.bootcampsbcalculator.model.CalOperation;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.exception.BusinessException;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.exception.SysCode;
import com.vtxlab.bootcamp.bootcampsbcalculator.service.CalculatorService;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public double getCalculation(String x, String y, String operation) {

        return getResult(Double.parseDouble(x),
                Double.parseDouble(y), getCalOperation(operation));
    }

    private Double getResult(double x, double y, CalOperation op) {
        switch (op) {
            case ADD:
                return BigDecimal.valueOf(x)
                        .add(BigDecimal.valueOf(y))
                        .doubleValue();
            case SUB:
                return BigDecimal.valueOf(x)
                        .subtract(BigDecimal.valueOf(y))
                        .doubleValue();
            case MUL:
                return BigDecimal.valueOf(x)
                        .multiply(BigDecimal.valueOf(y))
                        .doubleValue();
            case DIV:
                return BigDecimal.valueOf(x)
                        .divide(BigDecimal.valueOf(y), 5, RoundingMode.HALF_UP)
                        .doubleValue();
            default:
                return null;
        }
    }

    private CalOperation getCalOperation(String operation) {
        for (CalOperation e : CalOperation.values())
            if (e.name().compareToIgnoreCase(operation) == 0)
                return e;
        throw new BusinessException(SysCode.ILLEGAL_ARGUMENT_EXCEPTION);
    }

    // @Override
    // public double add(double x, double y) {
    // return BigDecimal.valueOf(x)
    // .add(BigDecimal.valueOf(y))
    // .doubleValue();
    // }

    // @Override
    // public double subtract(double x, double y) {
    // return BigDecimal.valueOf(x)
    // .subtract(BigDecimal.valueOf(y))
    // .doubleValue();
    // }

    // @Override
    // public double multiply(double x, double y) {
    // return BigDecimal.valueOf(x)
    // .multiply(BigDecimal.valueOf(y))
    // .doubleValue();
    // }

    // @Override
    // public double divide(double x, double y) {
    // if(y == 0)
    // throw new IllegalArgumentException();
    // return BigDecimal.valueOf(x)
    // .divide(BigDecimal.valueOf(y),4, RoundingMode.HALF_UP)
    // .doubleValue();
    // }

    // @Override
    // public int quotient(int x, int y){
    // if(y == 0)
    // throw new IllegalArgumentException();
    // return x % y;
    // }
}
