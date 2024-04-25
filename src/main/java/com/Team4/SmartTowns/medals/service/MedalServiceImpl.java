package com.Team4.SmartTowns.medals.service;

//import com.Team4.SmartTowns.checkpoints.model.Checkpoint;
//import com.Team4.SmartTowns.checkpoints.service.CheckpointService;
import com.Team4.SmartTowns.medals.model.MedalRepository;
import com.Team4.SmartTowns.medals.model.Medal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedalServiceImpl implements MedalService {

    private MedalRepository medalRepository;
//    private CheckpointService checkpointService;

//    public MedalServiceImpl(CheckpointService checkpointService, MedalRepository medalRepository) {
//        this.checkpointService = checkpointService;
//        this.medalRepository = medalRepository;
//    }

//    @Override
//    public void awardMedalToUser(String username) {
//
//        List<Checkpoint> checkpointsReached = checkpointService.getCheckpointsByUsername(username);
//        int sumCheckpoints = checkpointsReached.size();
//
////        String medalAwarded = determineMedal(sumCheckpoints);
////        if (!"none".equals(medalAwarded)) {
//        if (sumCheckpoints >= 20) {
//            medalRepository.saveMedalToUser("BRONZE - 20 Checkpoints", username);
//        }
//
//        if (sumCheckpoints >= 40) {
//            medalRepository.saveMedalToUser("SILVER - 40 Checkpoints", username);
//        }
////
//        if (sumCheckpoints >= 60) {
//            medalRepository.saveMedalToUser("GOLD - 60 Checkpoints", username);
//        }
////
////            medalRepository.saveMedalToUser(medalAwarded, username);
//
//    }

    @Autowired
    public void MedalService(MedalRepository medalRepository) {
        this.medalRepository = medalRepository;
    }

    public List<Medal> getAllMedals() {
        return medalRepository.findAllMedals();
    }

//    @Override
//    public List<Medal> getMedalsForUser(String username) {
//        return medalRepository.findMedalsForUser(username);
//    }


//        this method has been deprecated as shown in the awardMedalToUser() method.
//        private String determineMedal ( int sumCheckpoints){
//            if (sumCheckpoints >= 60) {
//                return "GOLD";
//            } else if (sumCheckpoints >= 40) {
//                return "SILVER";
//            } else if (sumCheckpoints >= 20) {
//                return "BRONZE";
//            } else {
//                return "none";
//            }
//        }


}
