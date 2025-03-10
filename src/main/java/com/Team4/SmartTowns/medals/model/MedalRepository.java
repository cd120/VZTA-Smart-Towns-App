package com.Team4.SmartTowns.medals.model;

//import com.Team4.SmartTowns.trails.model.Trail;

import java.util.List;


public interface MedalRepository {

    void saveMedalToUser(String username, String medalName);
    List<Medal> findMedalsForUser(String username);

    List<Medal> findAllMedals();


}