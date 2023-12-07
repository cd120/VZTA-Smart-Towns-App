package com.Team4.SmartTowns.medals.model;

import com.Team4.SmartTowns.profile.model.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.List;

public class MedalRepositoryImpl {

    private JdbcTemplate jdbc;
    private RowMapper<Medal> medalMapper;

    public MedalRepositoryImpl(JdbcTemplate aJdbc) {
        this.jdbc = aJdbc;
        setMedalMapper();
    }


    private void setMedalMapper() {
        this.medalMapper = (ResultSet resultSet, int rowNum) -> {
            Medal medal = new Medal();
            medal.setId(resultSet.getLong("id"));
            medal.setName(resultSet.getString("name"));
            medal.setMedalType(MedalType.valueOf(resultSet.getString("medal_type")));
            medal.setCheckpointsSum(resultSet.getInt("checkpoints_sum"));
            medal.setMedalType(MedalType.valueOf(resultSet.getString("medal_type")));

            return medal;
        };
    }

    @Override
    public List<Medal> findMedalForUsers() {
        String sql = "SELECT username";
        return jdbc.query(sql, medalMapper);
    }
}
