package com.Team4.SmartTowns.leaderboard.controller;

import com.Team4.SmartTowns.leaderboard.service.LeaderboardService;
import com.Team4.SmartTowns.trails.model.Trail;
import com.Team4.SmartTowns.trails.service.TrailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LeaderboardController {
    private LeaderboardService leaderboardService;

    public LeaderboardController(LeaderboardService leaderboardService){
        this.leaderboardService = leaderboardService;
    }

    @GetMapping("/leaderboard")
    public ModelAndView getLeaderboard(){
        ModelAndView mav = new ModelAndView("leaderboard/leaderboard");
        mav.addObject("leaderboard", leaderboardService.getCheckpointLeaderboard());
        return mav;
    }
}
