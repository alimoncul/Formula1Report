package com.alimoncul.formula1report.FormulaApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QualifyingResult {

    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("position")
    @Expose
    private String position;
    @SerializedName("Driver")
    @Expose
    private Driver driver;
    @SerializedName("Constructor")
    @Expose
    private Constructor constructor;
    @SerializedName("Q1")
    @Expose
    private String q1;
    @SerializedName("Q2")
    @Expose
    private String q2;
    @SerializedName("Q3")
    @Expose
    private String q3;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Constructor getConstructor() {
        return constructor;
    }

    public void setConstructor(Constructor constructor) {
        this.constructor = constructor;
    }

    public String getQ1() {
        return q1;
    }

    public void setQ1(String q1) {
        this.q1 = q1;
    }

    public String getQ2() {
        return q2;
    }

    public void setQ2(String q2) {
        this.q2 = q2;
    }

    public String getQ3() {
        return q3;
    }

    public void setQ3(String q3) {
        this.q3 = q3;
    }

}