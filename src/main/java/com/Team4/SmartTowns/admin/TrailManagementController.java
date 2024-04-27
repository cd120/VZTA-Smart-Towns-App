package com.Team4.SmartTowns.admin;

import com.Team4.SmartTowns.trails.model.Trail;
import com.Team4.SmartTowns.trails.service.TrailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TrailManagementController {

    private TrailService trailService;

    public TrailManagementController(TrailService trailService){
        this.trailService = trailService;
    }

    @GetMapping("/admin/trails/add")
    public ModelAndView getAddTrail(){
        ModelAndView mav = new ModelAndView("admin/createTrail");
        mav.addObject("trail", new Trail());
        return mav;
    }

    @PostMapping("/admin/trails/add")
    public ModelAndView postAddTrail(@ModelAttribute("trail") Trail trail){
        // use the trail service to add the trail
        // if no errors:
        Long id = trailService.createTrail(trail);
        System.out.println(trailService.getTrailById(id));
        ModelAndView mav = new ModelAndView("redirect:/");
        return mav;
    }
}
