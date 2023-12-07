package com.Team4.SmartTowns.medals.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Medal {
    private Long medalId;
    private String medalName;
    private String medalDescription;
    private int checkpointsSum;
    private String medalType;

    public Medal() {

        this.medalId = null;
        this.medalName = "";
        this.medalDescription = "";
        this.checkpointsSum = 0;
        this.medalType = null;
    }

}
