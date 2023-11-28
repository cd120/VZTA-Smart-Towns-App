package com.Team4.SmartTowns.checkpoints.model;

import com.Team4.SmartTowns.trails.model.Trail;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
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
        this.description = "";
        this.trail = null;
    }

    public void setTrail(Trail trail) {
    }

    public Object getId() {
        return id;
    }

    public void setName(String name) {
    }

    public void setCoordinates(double[] doubles) {
    }

    public Checkpoint getTrail() {
    }

    public void setId(Long checkpointId) {
    }
}
