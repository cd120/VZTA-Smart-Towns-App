package com.Team4.SmartTowns.checkpoints.model;
import com.Team4.SmartTowns.checkpoints.model.Checkpoint;

import java.util.List;

public interface CheckpointRepository {
    Checkpoint findCheckpointById(Long checkpoint_id);
    List<Checkpoint> findCheckpointsByUsername(String username);
    List<Checkpoint> findCheckpointsByTrailId(Long trail_id);
    List<Checkpoint> findAllCheckpoints();
    Long saveCheckpoint(Checkpoint checkpoint);
    void addCheckpointToUser(Long checkpoint_id, String username);

//    int sumCheckpointValuesByUsername(String username);
}

