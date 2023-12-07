package com.Team4.SmartTowns.medals.model;

import java.util.List;

public interface MedalRepository {

    List<Medal> findMedalsForUsers(String username);
    //find data from the database
}
