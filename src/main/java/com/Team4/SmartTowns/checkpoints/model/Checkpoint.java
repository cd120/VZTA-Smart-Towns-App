package com.Team4.SmartTowns.checkpoints.model;

import com.Team4.SmartTowns.trails.model.Trail;

public class Checkpoint {

    private Long id;
    private String name;
    private double[] coordinates;
    private Trail trail;
    private String description;

    public Checkpoint() {
        this.id = null;
        this.name = "";
        this.coordinates = new double[2];
        this.trail = null;
        this.description = "";
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public Trail getTrail() {
        return trail;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public void setTrail(Trail trail) {
        this.trail = trail;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
