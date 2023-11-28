package com.Team4.SmartTowns.checkpoints.service;

import com.Team4.SmartTowns.checkpoints.model.Checkpoint;
import com.Team4.SmartTowns.checkpoints.model.CheckpointRepository;
import com.Team4.SmartTowns.checkpoints.service.CheckpointService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckpointServiceImpl implements CheckpointService {
    CheckpointRepository checkpointRepository;

    public CheckpointServiceImpl(CheckpointRepository checkpointRepository){
        this.checkpointRepository = checkpointRepository;
    }

    @Override
    public Checkpoint getCheckpointById(Long checkpoint_id) {
        return checkpointRepository.findCheckpointById(checkpoint_id);
    }

    @Override
    public List<Checkpoint> getCheckpointsByUsername(String username) {
        return checkpointRepository.findCheckpointsByUsername(username);
    }

    @Override
    public List<Checkpoint> getCheckpointsByTrailId(Long trail_id) {
        return checkpointRepository.findCheckpointsByTrailId(trail_id);
    }

    @Override
    public List<Checkpoint> getAllCheckpoints() {
        return checkpointRepository.findAllCheckpoints();
    }

    @Override
    public Long createCheckpoint(Checkpoint checkpoint) {
        return checkpointRepository.saveCheckpoint(checkpoint);
    }

    @Override
    public void addCheckpointToUser(Long checkpoint_id, String username) {
        checkpointRepository.addCheckpointToUser(checkpoint_id, username);
    }
}
