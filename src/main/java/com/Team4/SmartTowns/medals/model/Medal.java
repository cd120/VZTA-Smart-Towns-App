package com.Team4.SmartTowns.medals.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Medal {
    private String medalName;
    private String medalDescription;


    public Medal() {

        this.medalName = "";
        this.medalDescription = "";

    }

}
