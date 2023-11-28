package com.Team4.SmartTowns.trails.model;
import com.Team4.SmartTowns.trails.model.Trail;

import java.util.List;

public interface TrailRepository {
    Trail findTrailById(Long trailId);
    Long saveTrail(Trail trail);
    List<Trail> findAllTrails();

    List<Trail> searchTrails(String query);
}