package com.Team4.SmartTowns.leaderboard.service;


import com.Team4.SmartTowns.leaderboard.model.LeaderboardRepository;
import com.Team4.SmartTowns.leaderboard.model.LeaderboardRepositoryImpl;
import com.Team4.SmartTowns.leaderboard.model.LeaderboardUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderboardServiceImpl implements LeaderboardService{

    LeaderboardRepository leaderboardRepository;

    public LeaderboardServiceImpl(LeaderboardRepository leaderboardRepository){
        this.leaderboardRepository = leaderboardRepository;
    }

    @Override
    public List<LeaderboardUser> getCheckpointLeaderboard() {
        return leaderboardRepository.findCheckpointLeaderboard();
    }
}
