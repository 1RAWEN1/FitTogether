package com.example.application.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

public class Placemark {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @Min(value = -90)
    @Max(value = 90)
    private double latitude;

    @NotNull
    @Min(value = -180)
    @Max(value = 180)
    private double longitude;

    @NotNull
    private long leaderId;

    @NotNull
    @NotEmpty
    @NotBlank
    private String name;
    @NotNull
    @NotEmpty
    @NotBlank
    private String description;
    @NotNull
    @Min(value = 0)
    private int minAge;
    @NotNull
    @Positive
    private int maxAge;
    @NotNull
    @Basic
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date activityDate;
    @NotNull
    @NotEmpty
    @NotBlank
    private String sportType;
    @NotNull
    @Min(value = 1)
    private int participantsNumber;

    public Placemark(double latitude, double longitude, long leaderId, String name, String description, int minAge, int maxAge, Date activityDate, String sportType, int participantsNumber) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.leaderId = leaderId;
        this.name = name;
        this.description = description;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.activityDate = activityDate;
        this.sportType = sportType;
        this.participantsNumber = participantsNumber;
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

    public long getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(long leaderId) {
        this.leaderId = leaderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public Date getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    public int getParticipantsNumber() {
        return participantsNumber;
    }

    public void setParticipantsNumber(int participantsNumber) {
        this.participantsNumber = participantsNumber;
    }
}
