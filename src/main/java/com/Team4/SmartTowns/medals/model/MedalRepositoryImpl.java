package com.Team4.SmartTowns.medals.model;

import com.Team4.SmartTowns.profile.model.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;
@Repository
public class MedalRepositoryImpl implements MedalRepository{

    private JdbcTemplate jdbc;
    private RowMapper<Medal> medalMapper;

    public MedalRepositoryImpl(JdbcTemplate aJdbc) {
        this.jdbc = aJdbc;
        setMedalMapper();
    }

    private void setMedalMapper() {
        this.medalMapper = (ResultSet resultSet, int rowNum) -> {
            Medal medal = new Medal();
            medal.setMedalName(resultSet.getString("medal_name"));
            medal.setMedalDescription(resultSet.getString("medal_description"));

            return medal;
        };
    }
    @Override
    public void saveMedalToUser(String medalName, String username) {
        String sql = "INSERT INTO medal_users (username, medal_name) VALUES  (?,?)";
        jdbc.update(sql, username, medalName);
    }

    @Override
    public List<Medal> findMedalsForUser(String username) {
        String sql = "SELECT m.* from medal_types m " +
                "JOIN medal_users mu ON m.medal_name = mu.medal_name " +
                "WHERE mu.username = ?";
        return jdbc.query(sql, medalMapper, username);
    }

}