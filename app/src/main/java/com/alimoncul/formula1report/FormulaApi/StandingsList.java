package com.alimoncul.formula1report.FormulaApi;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StandingsList {

    @SerializedName("season")
    @Expose
    private String season;
    @SerializedName("round")
    @Expose
    private String round;
    @SerializedName("DriverStandings")
    @Expose
    private List<DriverStanding> driverStandings = null;
    @SerializedName("ConstructorStandings")
    @Expose
    private List<ConstructorStanding> constructorStandings = null;

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public List<DriverStanding> getDriverStandings() {
        return driverStandings;
    }

    public void setDriverStandings(List<DriverStanding> driverStandings) {
        this.driverStandings = driverStandings;
    }
    public List<ConstructorStanding> getConstructorStandings() {
        return constructorStandings;
    }

    public void setConstructorStandings(List<ConstructorStanding> constructorStandings) {
        this.constructorStandings = constructorStandings;
    }

}
