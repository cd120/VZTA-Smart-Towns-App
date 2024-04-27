package com.Team4.SmartTowns.checkpoints.service;

import com.Team4.SmartTowns.checkpoints.model.Checkpoint;

import java.util.List;

public interface CheckpointService {
    Checkpoint getCheckpointById(Long checkpoint_id);
    List<Checkpoint> getCheckpointsByUsername(String username);
    List<Checkpoint> getCheckpointsByTrailId(Long trail_id);
    List<Checkpoint> getAllCheckpoints();
    Long createCheckpoint(Checkpoint checkpoint);
    void addCheckpointToUser(Long checkpoint_id, String username);
}
