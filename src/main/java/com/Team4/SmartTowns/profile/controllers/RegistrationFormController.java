package com.Team4.SmartTowns.profile.controllers;

import com.Team4.SmartTowns.profile.model.Profile;
import com.Team4.SmartTowns.profile.model.ProfileRepository;
import com.Team4.SmartTowns.profile.service.ProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationFormController {

    private ProfileService profileService;

    public RegistrationFormController(ProfileService profileService){
        this.profileService = profileService;
    }

    //not used
    @GetMapping(value = {"/registration"})
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView("/registration/registrationForm");
        modelAndView.addObject("registrationForm", new Profile());
         return modelAndView;
    }

    //not used
    @GetMapping("/registration/newregister")
    @ResponseBody
    public String postResponseController() {
        return ";";
    }

//not used
    @PostMapping("/registration/newregister")
    public ModelAndView postAddTrail(@ModelAttribute("registrationForm") Profile registrationForm){
        System.out.println(registrationForm.getUserName());
        String username = profileService.addProfile(registrationForm);
        System.out.println(username);
        ModelAndView mav = new ModelAndView("redirect:/");

        return mav;
    }



}
