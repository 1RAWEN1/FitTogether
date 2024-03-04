package com.example.application.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Placemark {
    @NotNull
    @Min(value = -90)
    @Max(value = 90)
    private double latitude;

    @NotNull
    @Min(value = -180)
    @Max(value = 180)
    private double longitude;

    public Placemark(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
