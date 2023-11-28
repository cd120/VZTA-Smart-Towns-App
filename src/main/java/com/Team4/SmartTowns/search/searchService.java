package com.Team4.SmartTowns.search;

import com.Team4.SmartTowns.trails.model.Trail;
import com.Team4.SmartTowns.trails.model.TrailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class searchService {

    private final TrailRepository trailRepository;

    @Autowired
    public searchService(TrailRepository trailRepository) {
        this.trailRepository = trailRepository;
    }

    public List<Trail> searchTrails(String query) {

        return null;
    }


}
