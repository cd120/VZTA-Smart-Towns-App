package com.Team4.SmartTowns.trails.service;

import com.Team4.SmartTowns.trails.model.Trail;
import com.Team4.SmartTowns.trails.model.TrailRepository;
import com.Team4.SmartTowns.trails.service.TrailService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrailServiceImpl implements TrailService {
    private TrailRepository trailRepository;
    public TrailServiceImpl(TrailRepository trailRepository) {
        this.trailRepository = trailRepository;
    }

    @Override
    public Long createTrail(Trail trail) {
        return trailRepository.saveTrail(trail);
    }

    @Override
    public List<Trail> getAllTrails() {
        return trailRepository.findAllTrails();
    }

    @Override
    public Trail getTrailById(Long id) {
        return trailRepository.findTrailById(id);
    }
    @Override
    public Trail getTrailByCheckpointId(Long id) {return trailRepository.findTrailByCheckpointId(id);}

    @Override
    public List<Trail> getStartedTrailsByUsername(String username){
        return trailRepository.findStartedTrailsByUsername(username);
    }
}
