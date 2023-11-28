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
}
