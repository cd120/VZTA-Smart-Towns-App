package com.Team4.SmartTowns.profile.controllers;


import com.Team4.SmartTowns.checkpoints.model.Checkpoint;
import com.Team4.SmartTowns.medals.model.Medal;
import com.Team4.SmartTowns.medals.service.MedalService;
import com.Team4.SmartTowns.profile.model.Profile;
import com.Team4.SmartTowns.profile.service.ProfileService;
import com.Team4.SmartTowns.trails.model.Trail;
import com.Team4.SmartTowns.trails.service.TrailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProfileController {

    private ProfileService profileService;
    private TrailService trailService;
    private MedalService medalService;

    public ProfileController(ProfileService profileService, TrailService trailService, MedalService medalService){
        this.profileService = profileService;
        this.trailService = trailService;
        this.medalService = medalService;
    }

    @GetMapping("/profile")
    public ModelAndView getProfile(Principal principal) {
        ModelAndView mav = new ModelAndView("profile/profile-new");
        String loggedInUser = principal.getName();

        List<Trail> startedTrails = trailService.getStartedTrailsByUsername(loggedInUser);
        Profile profile = profileService.getProfile(loggedInUser);
        profile.setPassword("");

        // create list of checkpoint ids that the profile has collected
        List<Long> profileCheckpointIds = new ArrayList<>();
        for (Checkpoint checkpoint : profile.getCheckpoints()){
            profileCheckpointIds.add(checkpoint.getId());
        }

        // calculate progress for each trail, creating a map of collected checkpoints for each trail
        Map<Long, List<Long>> checkpointIdsByTrail = new HashMap<>();
        for (Trail trail : startedTrails) {
            List<Long> collectedCheckpoints = new ArrayList<>();
            for (Checkpoint checkpoint : trail.getCheckpoints()) {
                if (profileCheckpointIds.contains(checkpoint.getId())) {
                    collectedCheckpoints.add(checkpoint.getId());
                }
            }
            checkpointIdsByTrail.put(trail.getId(), collectedCheckpoints);
        }

        // calculate the percentages of each trail completed
        Map<Long, Float> percentages = new HashMap<>();
        for(Trail trail: startedTrails){
            float percentage = (checkpointIdsByTrail.get(trail.getId()).size() * 100)/trail.getCheckpoints().size();
            percentages.put(trail.getId(), percentage);
        }

        // get the users medals
        List<Medal> userMedals = medalService.getMedalsForUser(loggedInUser);
        mav.addObject("userMedals", userMedals);
        mav.addObject("percentages", percentages);
        mav.addObject("profile", profile);
        mav.addObject("startedTrails", startedTrails);
        mav.addObject("checkpointsIdsByTrail", checkpointIdsByTrail);

        return mav;
    }



}
