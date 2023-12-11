//package com.Team4.SmartTowns.medals.model;
//
//
//import com.Team4.SmartTowns.medals.service.MedalService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class MedalController {
//
//    private MedalService medalService;
//
//    public MedalController(MedalService medalService){
//        this.medalService = medalService;
//    }
//
//    @GetMapping ("/medal")
//    public ModelAndView getMedals(){
//        ModelAndView mvc = new ModelAndView("medals/medals");
//        mvc.addObject("medals",medalService.getMedalsForUser());
//        return mvc;
//    }
//}
//
////DELETE