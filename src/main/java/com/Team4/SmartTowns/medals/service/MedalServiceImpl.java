package com.Team4.SmartTowns.medals.service;

import com.Team4.SmartTowns.checkpoints.model.Checkpoint;
import com.Team4.SmartTowns.checkpoints.model.CheckpointRepository;
import com.Team4.SmartTowns.checkpoints.service.CheckpointService;
import com.Team4.SmartTowns.medals.model.MedalRepository;
import com.Team4.SmartTowns.medals.model.Medal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedalServiceImpl implements MedalService {

    private MedalRepository medalRepository;
    private CheckpointService checkpointService;

    public MedalServiceImpl(CheckpointService checkpointService, MedalRepository medalRepository){
        this.checkpointService = checkpointService;
        this.medalRepository = medalRepository;
    }

    @Override
    public void awardMedalToUser(String username) {

        List<Checkpoint> checkpointsReached = checkpointService.getCheckpointsByUsername(username);
        int sumCheckpoints = checkpointsReached.size();

        String medalAwarded = determineMedal(sumCheckpoints);
        if (!"none".equals(medalAwarded)) {
            medalRepository.saveMedalToUser(medalAwarded, username);
        }
    }

    @Override
    public List<Medal> getMedalsForUser(String username) {
        return medalRepository.findMedalsForUser(username);
    }

    private String determineMedal(int sumCheckpoints) {
        if (sumCheckpoints >= 60) {
            return "GOLD";
        } else if (sumCheckpoints >= 40) {
            return "SILVER";
        } else if (sumCheckpoints >= 20) {
            return "BRONZE";
        } else {
            return "none";
        }
    }


}
