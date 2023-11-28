package com.Team4.SmartTowns.trails.model;

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

    public Long getId() {
        return id;
    }

    public List<Checkpoint> getCheckpoints() {
        return checkpoints;
    }

    public Object getName() {
        return name;
    }

    public Object getLocation() {
        return location;
    }

    public Object getDescription() {
        return description;
    }

    //SETTERS

    public void setCheckpoints(List<Checkpoint> trailId) {
    }


    public void setName(String name) {
    }

    public void setLocation(String location) {
    }

    public void setDescription(String description) {
    }

    public void setId(Long trailId) {
    }
}
