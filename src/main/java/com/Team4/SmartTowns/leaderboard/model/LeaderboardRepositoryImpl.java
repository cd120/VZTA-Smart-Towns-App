package com.Team4.SmartTowns.leaderboard.model;

import com.Team4.SmartTowns.checkpoints.model.Checkpoint;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LeaderboardRepositoryImpl implements LeaderboardRepository {
    private JdbcTemplate jdbc;
    private RowMapper<LeaderboardUser> leaderboardRowMapper;

    public LeaderboardRepositoryImpl(JdbcTemplate aJdbc) {
        this.jdbc = aJdbc;
        setLeaderboardRowMapper();
    }

    private void setLeaderboardRowMapper() {
        this.leaderboardRowMapper = (resultSet, i) -> {
            LeaderboardUser leaderboardUser = new LeaderboardUser();
            leaderboardUser.setPosition(i + 1); // Position is 1-based
            leaderboardUser.setUsername(resultSet.getString("username"));
            leaderboardUser.setCount(resultSet.getInt("count"));
            return leaderboardUser;
        };
    }

    @Override
    public List<LeaderboardUser> findCheckpointLeaderboard() {
        String sql = "SELECT username, COUNT(*) as count FROM user_checkpoints GROUP BY username ORDER BY count DESC";
        return jdbc.query(sql, leaderboardRowMapper);
    }
}
