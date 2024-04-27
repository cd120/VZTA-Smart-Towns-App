package com.Team4.SmartTowns.profile.service;

import com.Team4.SmartTowns.profile.model.Profile;

public interface ProfileService {
    String addProfile(Profile profile);
    Profile getProfile(String username);
}
