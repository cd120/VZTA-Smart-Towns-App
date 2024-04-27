package com.Team4.SmartTowns.trails.model;
import com.Team4.SmartTowns.trails.model.Trail;

import java.util.List;

public interface TrailRepository {
    Trail findTrailById(Long trail_id);
    Long saveTrail(Trail trail);
    List<Trail> findAllTrails();
    Trail findTrailByCheckpointId(Long checkpoint_id);
    List<Trail> findStartedTrailsByUsername(String username);
}
