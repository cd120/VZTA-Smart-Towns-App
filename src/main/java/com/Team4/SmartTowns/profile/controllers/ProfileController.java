package com.Team4.SmartTowns.profile.controllers;


import com.Team4.SmartTowns.profile.model.Profile;
import com.Team4.SmartTowns.profile.service.ProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class ProfileController {
    private ProfileService profileService;

    public ProfileController(ProfileService profileService){
        this.profileService = profileService;
    }

//    @GetMapping(value = {"/profile"})
//    public ModelAndView profile() {
//
//
//        ModelAndView modelAndView = new ModelAndView("/profile/profilePage");
////       modelAndView.setViewName("profilePage.html");
//// getProfile username
////        return valid or not
//// profileService
//        //dummy data for the profile page fields.
//        modelAndView.addObject("name", loggedIn);
//        modelAndView.addObject("town", "Cardiff Town");
//        modelAndView.addObject("unlockedTrails", 2);
//        modelAndView.addObject("completedTrails", 4);
//
//        modelAndView.addObject("lockedTrails", 2);
//        modelAndView.addObject("about", "Loving the new Trail application!");
//        return modelAndView;
//    }


    @GetMapping("/profile")
    public ModelAndView getProfile(Principal principal) {
        String loggedInUser = principal.getName();
        Profile loggedIn = profileService.getProfileByUsername(loggedInUser);
        ModelAndView modelAndView = new ModelAndView("/profile/profilePage");
        modelAndView.addObject("profile", loggedIn);
        return modelAndView;
    }


}
