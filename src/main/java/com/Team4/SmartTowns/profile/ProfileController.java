package com.Team4.SmartTowns.profile;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {
    @GetMapping(value = {"/profile"})
    public ModelAndView userName(){
        ModelAndView modelAndView = new ModelAndView("/profile/profilePage");
//       modelAndView.setViewName("profilePage.html");

       //dummy data for the profile page fields.
       modelAndView.addObject("name", "John");
        modelAndView.addObject("town", "Cardiff Town");
        modelAndView.addObject("unlockedTrails", 2);
        modelAndView.addObject("completedTrails", 4);

        modelAndView.addObject("lockedTrails", 2);
        modelAndView.addObject("about", "I love trails\n" +
                "\n" +
                "Embarking on a Journey\n" +
                "\n" +
                "Cool Trail!");
    return modelAndView;
    }

}
