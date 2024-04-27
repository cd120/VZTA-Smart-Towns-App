package com.Team4.SmartTowns.testscripts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultsController {
    DefaultsGenerator defaultsGenerator;
    DefaultsController(DefaultsGenerator defaultsGenerator){
        this.defaultsGenerator = defaultsGenerator;
    }

    @GetMapping("/test")
    public ModelAndView runTest(){
        defaultsGenerator.generateTrailsAndUsers();
        return new ModelAndView("redirect:/");
    }
}
