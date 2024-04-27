package com.Team4.SmartTowns.profile.model;

public interface ProfileRepository {

    //method saveUser
    String saveProfile(Profile profile);
    Profile findProfile(String username);
}
