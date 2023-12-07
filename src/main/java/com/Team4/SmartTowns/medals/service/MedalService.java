package com.Team4.SmartTowns.medals.service;

import com.Team4.SmartTowns.medals.model.Medal;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MedalService {

    List<Medal> getMedalsForUser(String username);

    void addMedalToUser(String username, String medalName);
    Medal determineMedal(int checkpointSum);


}