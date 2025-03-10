package com.Team4.SmartTowns.trails.model;
import com.Team4.SmartTowns.checkpoints.model.Checkpoint;
import com.Team4.SmartTowns.checkpoints.model.CheckpointRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrailRepositoryImpl implements TrailRepository {
    private JdbcTemplate jdbc;
    private RowMapper<Trail> trailMapper;
    private CheckpointRepository checkpointRepository;

    public TrailRepositoryImpl(JdbcTemplate aJdbc, CheckpointRepository checkpointRepository) {
        this.jdbc = aJdbc;
        this.checkpointRepository = checkpointRepository;
        setTrailMapper();
    }

    private void setTrailMapper() {
        this.trailMapper = (resultSet, i) -> {
            Trail trail = new Trail();
            trail.setId(resultSet.getLong("trail_id"));
            trail.setName(resultSet.getString("name"));
            trail.setLocation(resultSet.getString("location"));
            trail.setDescription(resultSet.getString("description"));
            trail.setCheckpoints(checkpointRepository.findCheckpointsByTrailId(resultSet.getLong("trail_id")));
            return trail;
        };
    }
    @Override
    public Trail findTrailByCheckpointId(Long checkpoint_id){
        String sql = "SELECT t.* from trail_table t " +
                "JOIN trail_checkpoint tc ON t.trail_id = tc.trail_id " +
                "WHERE tc.checkpoint_id = ?";
        Trail trail = jdbc.queryForObject(sql, trailMapper, checkpoint_id);
        return trail;
    }

    @Override
    public List<Trail> findStartedTrailsByUsername(String username) {
        String sql = "SELECT DISTINCT t.* FROM user_checkpoints uc " +
                "JOIN trail_checkpoint tc ON uc.checkpoint_id = tc.checkpoint_id " +
                "JOIN trail_table t ON tc.trail_id = t.trail_id " +
                "WHERE uc.username = ?";
        return jdbc.query(sql, trailMapper, username);
    }

    @Override
    public List<Trail> findAllTrails() {
        String sql = "SELECT * FROM trail_table";
        return jdbc.query(sql, trailMapper);
    }

    @Override
    public Trail findTrailById(Long id) {
        String sql = "SELECT * FROM trail_table WHERE trail_id = ?";
        return jdbc.queryForObject(sql, trailMapper, id);
    }

    @Override
    public Long saveTrail(Trail trail) {
        return (trail.getId() != null) ? updateTrail(trail) : insertTrail(trail);
    }

    private Long insertTrail(Trail trail) {
        String sql = "INSERT INTO trail_table (name, location, description) VALUES (?, ?, ?) RETURNING trail_id";
        Long trailId = jdbc.queryForObject(sql, Long.class, trail.getName(), trail.getLocation(), trail.getDescription());
        trail.setId(trailId);
        saveCheckpoints(trail);
        return trailId;
    }

    private Long updateTrail(Trail trail) {
        String sql = "UPDATE trail_table SET name = ?, location = ?, description = ?, WHERE trail_id = ?";
        jdbc.update(sql, trail.getName(), trail.getLocation(), trail.getDescription(), trail.getId());
        saveCheckpoints(trail);
        return trail.getId();
    }

    private void saveCheckpoints(Trail trail) {
        for (Checkpoint checkpoint : trail.getCheckpoints()) {
            Long checkpoint_id = checkpointRepository.saveCheckpoint(checkpoint);
            String sql = "INSERT INTO trail_checkpoint (trail_id, checkpoint_id) VALUES (?, ?)";
            jdbc.update(sql, trail.getId(), checkpoint_id);
        }
    }
}
