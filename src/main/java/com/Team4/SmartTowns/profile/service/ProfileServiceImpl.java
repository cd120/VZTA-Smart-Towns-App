package com.Team4.SmartTowns.profile.service;

import com.Team4.SmartTowns.profile.model.ProfileRepository;
import com.Team4.SmartTowns.profile.model.Profile;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements  ProfileService {
    private ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository){
        this.profileRepository = profileRepository;
    }


    //addUserby Username?
    @Override
    public String addProfile(Profile profile)  {
        return profileRepository.saveProfile(profile);
    }

    @Override
    public Profile getProfile(String username) {
        return profileRepository.findProfile(username);
    }

}
