package com.Team4.SmartTowns.search.model;

import java.util.List;

public interface TrailRepository {
    Trail findTrailById(Long trailId);
    Long saveTrail(Trail trail);
    List<Trail> findAllTrails();

    List<Trail> searchTrails(String query);
}