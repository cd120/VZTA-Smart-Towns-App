package com.Team4.SmartTowns.trails.service;

import com.Team4.SmartTowns.trails.model.Trail;

import java.util.List;

public interface TrailService {
    Long createTrail(Trail trail);
    List<Trail> getAllTrails();
    Trail getTrailById(Long id);
}
