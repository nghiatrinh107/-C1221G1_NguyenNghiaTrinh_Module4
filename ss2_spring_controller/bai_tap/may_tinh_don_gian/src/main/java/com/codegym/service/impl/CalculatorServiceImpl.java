package com.codegym.service.impl;

import com.codegym.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements ICalculatorService {

    @Override
    public String calculator(int a, int b, String c) {
        int result = 0;
        switch (c){
            case "addition":
                result = a+b;
                return Integer.toString(result);
            case "subtraction":
                result = a-b;
                return Integer.toString(result);
            case "multiplication":
                result = a*b;
                return Integer.toString(result);
            case "division":
                if(b != 0){
                    result = a/b;
                    return Integer.toString(result);
                }else {
                    return "Ko đc mẫu bằng 0";
                }
            default:
                return "Sai rồi đó";
        }
    }
}
