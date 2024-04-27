package com.Team4.SmartTowns.leaderboard.model;

import java.util.List;

public interface LeaderboardRepository {
    List<LeaderboardUser> findCheckpointLeaderboard();
}
