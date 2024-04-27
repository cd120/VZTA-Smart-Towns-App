package com.Team4.SmartTowns.medals.controller;

import com.Team4.SmartTowns.medals.model.Medal;
import com.Team4.SmartTowns.medals.model.MedalRepository;
import com.Team4.SmartTowns.medals.service.MedalService;
//import com.Team4.SmartTowns.trails.model.Trail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MedalController {

    private MedalService medalService;

    @Autowired
    public MedalController(MedalService medalService) {
        this.medalService = medalService;
    }

//    @Autowired
//    public MedalController(MedalRepository pRepo) {
//        medalRepo = pRepo
//    }

    @GetMapping("/medals")
    public ModelAndView showMedals(Model model) {
        ModelAndView mvc = new ModelAndView("/medals/medals");
        List<Medal> medals = medalService.getAllMedals();
        mvc.addObject("medal",medals);
        return mvc;
    }

}


