package com.alimoncul.formula1report.FormulaApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Circuit {

    @SerializedName("circuitId")
    @Expose
    private String circuitId;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("circuitName")
    @Expose
    private String circuitName;
    @SerializedName("Location")
    @Expose
    private Location location;

    public String getCircuitId() {
        return circuitId;
    }

    public void setCircuitId(String circuitId) {
        this.circuitId = circuitId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCircuitName() {
        return circuitName;
    }

    public void setCircuitName(String circuitName) {
        this.circuitName = circuitName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
