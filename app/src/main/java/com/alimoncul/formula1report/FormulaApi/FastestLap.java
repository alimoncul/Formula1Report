package com.alimoncul.formula1report.FormulaApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FastestLap {

    @SerializedName("rank")
    @Expose
    private String rank;
    @SerializedName("lap")
    @Expose
    private String lap;
    @SerializedName("Time")
    @Expose
    private Time_ time;
    @SerializedName("AverageSpeed")
    @Expose
    private AverageSpeed averageSpeed;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getLap() {
        return lap;
    }

    public void setLap(String lap) {
        this.lap = lap;
    }

    public Time_ getTime() {
        return time;
    }

    public void setTime(Time_ time) {
        this.time = time;
    }

    public AverageSpeed getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(AverageSpeed averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

}
