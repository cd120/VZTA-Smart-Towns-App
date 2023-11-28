package com.Team4.SmartTowns.checkpoints.model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CheckpointRepositoryImpl implements CheckpointRepository {
    private final JdbcTemplate jdbc;
    private final RowMapper<Checkpoint> checkpointMapper;

    public CheckpointRepositoryImpl(JdbcTemplate aJdbc) {
        this.jdbc = aJdbc;
        this.checkpointMapper = (resultSet, i) -> {
            Checkpoint checkpoint = new Checkpoint();
            checkpoint.setId(resultSet.getLong("checkpoint_id"));
            checkpoint.setName(resultSet.getString("name"));
            checkpoint.setCoordinates(new double[]{resultSet.getDouble("latitude"), resultSet.getDouble("longitude")});
            checkpoint.setDescription(resultSet.getString("description"));
            // Set the trail object or its ID based on your schema
            return checkpoint;
        };
    }

    // ... Other methods

    private Long insertCheckpoint(Checkpoint checkpoint) {
        String sql = "INSERT INTO checkpoint_table (name, latitude, longitude, description) VALUES (?, ?, ?, ?) RETURNING checkpoint_id";
        Long checkpointId = jdbc.queryForObject(sql, Long.class, checkpoint.getName(), checkpoint.getCoordinates()[0], checkpoint.getCoordinates()[1], checkpoint.getDescription());
        checkpoint.setId(checkpointId);
        return checkpointId;
    }

    private Long updateCheckpoint(Checkpoint checkpoint) {
        Long trailId = (checkpoint.getTrail() != null) ? checkpoint.getTrail().getTrailId() : null;
        String sql = "UPDATE checkpoint_table SET trail_id = ?, name = ?, latitude = ?, longitude = ?, description = ? WHERE checkpoint_id = ?";
        jdbc.update(sql, trailId, checkpoint.getName(), checkpoint.getCoordinates()[0], checkpoint.getCoordinates()[1], checkpoint.getDescription(), checkpoint.getId());
        return checkpoint.getId();
    }}

