package com.Team4.SmartTowns.trails.controller;

import com.Team4.SmartTowns.checkpoints.model.Checkpoint;
import com.Team4.SmartTowns.checkpoints.service.CheckpointService;
import com.Team4.SmartTowns.trails.model.Trail;
import com.Team4.SmartTowns.trails.service.TrailService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TrailController {

    private TrailService trailService;
    @Autowired
    private CheckpointService CheckpointService;


    public TrailController(TrailService trailService, CheckpointService checkpointService){

        this.trailService = trailService;

    }

    @GetMapping("/trails")
    public ModelAndView showTrails() {
        ModelAndView mvc = new ModelAndView("/trails/trails");
        List<Trail> trails = trailService.getAllTrails();
        mvc.addObject("trails", trails);

        return mvc;
    }

    @GetMapping("/trails/{id}")
    public ModelAndView getDetails(@PathVariable Long id){
        ModelAndView mvc = new ModelAndView("trails/trailDetails");
        Trail trail = trailService.getTrailById(id);
        mvc.addObject("trail", trail);
        return mvc;
    }


    @GetMapping("/api/trails/{trailId}/checkpoints")
    public ResponseEntity<List<Checkpoint>> getCheckpointsByTrailId(@PathVariable Long trailId) {
        List<Checkpoint> checkpoints = CheckpointService.getCheckpointsByTrailId(trailId);
        return ResponseEntity.ok(checkpoints);
    }



}
