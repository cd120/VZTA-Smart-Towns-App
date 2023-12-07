package com.Team4.SmartTowns.medals.service;

import com.Team4.SmartTowns.checkpoints.model.CheckpointRepository;
import com.Team4.SmartTowns.medals.model.MedalRepository;
import com.Team4.SmartTowns.medals.model.Medal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedalServiceImpl implements MedalService {


    private CheckpointRepository checkpointRepository;
    private MedalRepository medalRepository;

    @Override
    public List<Medal> getMedalsForUser(String username) {
        return medalRepository.findMedalsForUsers(username);
    }

    @Override
    public void addMedalToUser(String username, String medalName) {
        int checkpointsReached = checkpointRepository.sumCheckpointValuesByUsername(username);

        Medal medal = determineMedal(checkpointsReached);

        medalRepository.save(new Medal(username, medal.getType()));

    }

    @Override
    public Medal determineMedal(int checkpointsSum) {
        if (checkpointsSum >= 60) {
            return new Medal(MedalType.GOLD);
        } else if (checkpointsSum >= 40) {
            return new Medal(MedalType.SILVER);
        } else if (checkpointsSum >=20) {
            return new Medal(MedalType.BRONZE);
        } else {
            return new Medal(MedalType.NONE);

        }



    }


}
