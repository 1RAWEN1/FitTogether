package com.example.application.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @CollectionTable(name="usr_table", joinColumns = @JoinColumn(name = "user_id"))
    private User manager;
    @NotNull
    private String name;
    @NotNull
    private String description;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @CollectionTable(name="placemark_table", joinColumns = @JoinColumn(name = "user_id"))
    private Placemark placemark;

    public Activity(long id, User manager, String name, String description, Placemark placemark) {
        this.id = id;
        this.manager = manager;
        this.name = name;
        this.description = description;
        this.placemark = placemark;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
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

    public Placemark getPlacemark() {
        return placemark;
    }

    public void setPlacemark(Placemark placemark) {
        this.placemark = placemark;
    }
}
