package com.Team4.SmartTowns.leaderboard.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LeaderboardUser {
    private int position;
    private String username;
    private int count;

    public LeaderboardUser(){
        this.position = 0;
        this.username = "";
        this.count = 0;
    }
}
