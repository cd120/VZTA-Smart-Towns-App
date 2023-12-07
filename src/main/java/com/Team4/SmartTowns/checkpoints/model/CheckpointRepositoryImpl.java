package com.Team4.SmartTowns.checkpoints.model;

import com.Team4.SmartTowns.checkpoints.model.Checkpoint;
import com.Team4.SmartTowns.checkpoints.model.CheckpointRepository;
import com.Team4.SmartTowns.trails.model.Trail;
import com.Team4.SmartTowns.trails.model.TrailRepository;
import com.Team4.SmartTowns.trails.service.TrailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CheckpointRepositoryImpl implements CheckpointRepository {
    private JdbcTemplate jdbc;
    private RowMapper<Checkpoint> checkpointMapper;

    public CheckpointRepositoryImpl(JdbcTemplate aJdbc) {
        this.jdbc = aJdbc;
        setCheckpointMapper();
    }

    private void setCheckpointMapper() {
        this.checkpointMapper = (resultSet, i) -> {
            Checkpoint checkpoint = new Checkpoint();
            checkpoint.setId(resultSet.getLong("checkpoint_id"));
            checkpoint.setName(resultSet.getString("name"));
            checkpoint.setCoordinates(new double[]{resultSet.getDouble("latitude"), resultSet.getDouble("longitude")});
            checkpoint.setDescription(resultSet.getString("description"));
            return checkpoint;
        };
    }

    @Override
    public List<Checkpoint> findAllCheckpoints() {
        String sql = "SELECT * FROM checkpoint_table";
        return jdbc.query(sql, checkpointMapper);
    }

    @Override
    public Checkpoint findCheckpointById(Long checkpoint_id) {
        String sql = "SELECT * FROM checkpoint_table WHERE checkpoint_id = ?";
        return jdbc.queryForObject(sql, checkpointMapper, checkpoint_id);
    }

    @Override
    public List<Checkpoint> findCheckpointsByUsername(String username) {
        String sql = "SELECT c.* FROM checkpoint_table c " +
                "JOIN user_checkpoints uc ON c.checkpoint_id = uc.checkpoint_id " +
                "WHERE uc.username = ?";
        return jdbc.query(sql, checkpointMapper, username);
    }

    @Override
    public List<Checkpoint> findCheckpointsByTrailId(Long trail_id) {
        String sql = "SELECT c.* from checkpoint_table c " +
                "JOIN trail_checkpoint tc ON c.checkpoint_id = tc.checkpoint_id " +
                "WHERE tc.trail_id = ?";
        return jdbc.query(sql, checkpointMapper, trail_id);
    }

    @Override
    public Long saveCheckpoint(Checkpoint checkpoint) {
        return (checkpoint.getId() != null) ? updateCheckpoint(checkpoint) : insertCheckpoint(checkpoint);
    }

    @Override
    public void addCheckpointToUser(Long checkpoint_id, String username) {
        String sql = "INSERT INTO user_checkpoints (username, checkpoint_id) VALUES (?, ?)";
        jdbc.update(sql, username, checkpoint_id);
    }

    private Long insertCheckpoint(Checkpoint checkpoint) {
        String sql = "INSERT INTO checkpoint_table (name, latitude, longitude, description) VALUES (?, ?, ?, ?) RETURNING checkpoint_id";
        return jdbc.queryForObject(sql, Long.class, checkpoint.getName(), checkpoint.getCoordinates()[0], checkpoint.getCoordinates()[1], checkpoint.getDescription());
    }

    private Long updateCheckpoint(Checkpoint checkpoint) {
        String sql = "UPDATE checkpoint_table SET name = ?, latitude = ?, longitude = ?, description = ? WHERE checkpoint_id = ? RETURNING checkpoint_id";
        return jdbc.queryForObject(sql, Long.class, checkpoint.getName(), checkpoint.getCoordinates()[0], checkpoint.getCoordinates()[1], checkpoint.getDescription(), checkpoint.getId());
    }

}
