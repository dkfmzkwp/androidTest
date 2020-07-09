package com.example.intenttest20200706;

import java.io.Serializable;

public class Student implements Serializable {

    //private static final long serialVersionUID = 1L;
    private int number1;
    private int number2;
    private String calculate;
    private int result;

    public Student(int number1, int number2, String calculate) {
        this.number1 = number1;
        this.number2 = number2;
        this.calculate = calculate;
    }

    public Student(int number1, int number2, String calculate, int result) {
        this.number1 = number1;
        this.number2 = number2;
        this.calculate = calculate;
        this.result = result;
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

    public String getCalculate() {
        return calculate;
    }

    public void setCalculate(String calculate) {
        this.calculate = calculate;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
