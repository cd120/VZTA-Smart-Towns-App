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
    @GetMapping(value = {"/profile-demo"})
    public ModelAndView profile() {
        ModelAndView modelAndView = new ModelAndView("/profile/profilePage");
        //dummy data for the profile page fields.
        modelAndView.addObject("name", "John");
        modelAndView.addObject("town", "Cardiff Town");
        modelAndView.addObject("unlockedTrails", 2);
        modelAndView.addObject("completedTrails", 4);
        modelAndView.addObject("lockedTrails", 2);
        modelAndView.addObject("about", "Loving the new Trail application!");
        return modelAndView;
    }


    @GetMapping("/profile")
    public ModelAndView getProfile(Principal principal) {
        ModelAndView mav = new ModelAndView("profile/profile-new");
        String loggedInUser = principal.getName();

        List<Trail> startedTrails = trailService.getStartedTrailsByUsername(loggedInUser);
        Profile profile = profileService.getProfile(loggedInUser);
        profile.setPassword("");

        // Calculate progress for each trail
        Map<String, List<Checkpoint>> checkpointsByTrail = new HashMap<>();
        for (Trail trail : startedTrails) {
            List<Checkpoint> collectedCheckpoints = new ArrayList<>();
            for (Checkpoint checkpoint : trail.getCheckpoints()) {
                if (profile.getCheckpoints().contains(checkpoint)) {
                    collectedCheckpoints.add(checkpoint);
                }
            }
            checkpointsByTrail.put(trail.getName(), collectedCheckpoints);
        }

        Map<String, Float> percentages = new HashMap<>();
        for(Trail trail: startedTrails){
            float percentage = (checkpointsByTrail.get(trail.getName()).size() * 100)/trail.getCheckpoints().size();
            percentages.put(trail.getName(), percentage);
        }
// get the users medals
        List<Medal> userMedals = medalService.getMedalsForUser(loggedInUser);
        mav.addObject("userMedals", userMedals);
        mav.addObject("percentages", percentages);
        mav.addObject("profile", profile);
        mav.addObject("startedTrails", startedTrails);
        mav.addObject("checkpointsByTrail", checkpointsByTrail);

        return mav;
    }



}
