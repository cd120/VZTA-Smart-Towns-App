package com.Team4.SmartTowns.medals.service;

import com.Team4.SmartTowns.medals.model.Medal;
import com.Team4.SmartTowns.trails.model.Trail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MedalService {

    void awardMedalToUser(String username);
    List<Medal> getMedalsForUser(String username);
    List<Medal> getAllMedals();
}