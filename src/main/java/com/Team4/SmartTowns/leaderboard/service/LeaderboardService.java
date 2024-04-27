package com.Team4.SmartTowns.leaderboard.service;

import com.Team4.SmartTowns.leaderboard.model.LeaderboardUser;

import java.util.List;

public interface LeaderboardService {
    List<LeaderboardUser> getCheckpointLeaderboard();
}
