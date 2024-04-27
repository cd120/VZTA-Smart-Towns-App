package com.Team4.SmartTowns.trails.service;

import com.Team4.SmartTowns.trails.model.Trail;

import java.util.List;

public interface TrailService {
    Long createTrail(Trail trail);
    List<Trail> getAllTrails();
    Trail getTrailById(Long id);
    Trail getTrailByCheckpointId(Long id);
    List<Trail> getStartedTrailsByUsername(String username);
}
