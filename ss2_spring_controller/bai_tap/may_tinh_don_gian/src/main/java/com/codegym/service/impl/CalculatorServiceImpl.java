package com.codegym.service.impl;

import com.codegym.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements ICalculatorService {

    @Override
    public int calculator(int a, int b, String c) {
        int result = 0;
        switch (c){
            case "addition":
                return result = a+b;
            case "subtraction":
                return result = a-b;
            case "multiplication":
                return result = a*b;
            case "division":
                return result = a/b;
            default:
                break;
        }
        return result;
    }
}
