package com.example.simplecalculatortest;

import android.os.Parcel;
import android.os.Parcelable;

public class Calculator implements Parcelable {
    private double number01;
    private double number02;
    private double result;
    private String calculator;

    public Calculator(double number01, double number02, double result, String calculator) {
        this.number01 = number01;
        this.number02 = number02;
        this.result = result;
        this.calculator = calculator;
    }

    protected Calculator(Parcel parcel) {
        this.number01 = parcel.readDouble();
        this.number02 = parcel.readDouble();
        this.result = parcel.readDouble();
        this.calculator = parcel.readString();
    }

    public static final Creator<Calculator> CREATOR = new Creator<Calculator>() {
        @Override
        public Calculator createFromParcel(Parcel parcel) {
            return new Calculator(parcel);
        }

        @Override
        public Calculator[] newArray(int size) {
            return new Calculator[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.number01);
        parcel.writeDouble(this.number02);
        parcel.writeDouble(this.result);
        parcel.writeString(this.calculator);
    }

    public double getNumber01() {
        return number01;
    }

    public void setNumber01(double number01) {
        this.number01 = number01;
    }

    public double getNumber02() {
        return number02;
    }

    public void setNumber02(double number02) {
        this.number02 = number02;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getCalculator() {
        return calculator;
    }

    public void setCalculator(String calculator) {
        this.calculator = calculator;
    }
}
