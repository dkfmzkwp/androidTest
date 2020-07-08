package com.example.chapter05test;

import java.io.Serializable;

public class Calculator implements Serializable {
    private int number1;
    private int number2;
    private int result;
    private String calculator;

    public Calculator(int number1, int number2, String calculator) {
        this.number1 = number1;
        this.number2 = number2;
        this.calculator = calculator;
    }

    public Calculator(int number1, int number2, int result, String calculator) {
        this.number1 = number1;
        this.number2 = number2;
        this.result = result;
        this.calculator = calculator;
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getCalculator() {
        return calculator;
    }

    public void setCalculator(String calculator) {
        this.calculator = calculator;
    }
}
