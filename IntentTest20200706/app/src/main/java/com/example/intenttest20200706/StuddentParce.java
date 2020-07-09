package com.example.intenttest20200706;

import android.os.Parcel;
import android.os.Parcelable;

public class StuddentParce implements Parcelable {

    private int number1;
    private int number2;
    private String calculate;
    private int result;

    public StuddentParce(int number1, int number2, String calculate, int result) {
        this.number1 = number1;
        this.number2 = number2;
        this.calculate = calculate;
        this.result = result;
    }

    //매개변수 있는 생성자 (parcel *) parcel -> studentparcel
    protected StuddentParce(Parcel parcel) {
        this.number1 = parcel.readInt();
        this.number2 = parcel.readInt();
        this.calculate = parcel.readString();
        this.result = parcel.readInt();
    }

    public static final Creator<StuddentParce> CREATOR = new Creator<StuddentParce>() {
        @Override
        public StuddentParce createFromParcel(Parcel parcel) {
            return new StuddentParce(parcel);
        }

        @Override
        public StuddentParce[] newArray(int size) {
            return new StuddentParce[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    //studentparcel -> parcel 넣는다
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.number1);
        parcel.writeInt(this.number2);
        parcel.writeString(this.calculate);
        parcel.writeInt(this.result);
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
