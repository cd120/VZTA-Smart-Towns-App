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
        for(int i = 0; i < 20; i++) {
            Checkpoint checkpoint = new Checkpoint();
            this.checkpoints.add(checkpoint);
        }
    }


}
