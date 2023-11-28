package com.Team4.SmartTowns.search.model;

import com.Team4.SmartTowns.checkpoints.model.Checkpoint;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Trail {


    private Long id;
    private String name;
    private String location;
    private List<Checkpoint> checkpoints;

    private String description;

    public Trail(){
        this.id = null;
        this.name = "";
        this.location = "";
        this.checkpoints = new ArrayList<Checkpoint>();
        this.description = "";
        for(int i = 0; i < 15; i++) {
            Checkpoint checkpoint = new Checkpoint();
            checkpoint.setTrail(this);
            this.checkpoints.add(checkpoint);
        }
    }

    //GETTERS

    public Long getTrailId() {
        return id;
    }

    public List<Checkpoint> getCheckpoints() {
        return checkpoints;
    }

    public Object getTrailName() {
        return name;
    }

    public Object getTrailLocation() {
        return location;
    }

    public Object getTrailDescription() {
        return description;
    }

    //SETTERS

    public void setCheckpoints(List<Checkpoint> checkpoints) {
        this.checkpoints = checkpoints;
    }

    public void setTrailName(String name) {
        this.name = name;
    }

    public void setTrailLocation(String location) {
        this.location = location;
    }

    public void setTrailDescription(String description) {
        this.description = description;
    }

    public void setTrailId(Long id) {
        this.id = id;
    }
}
