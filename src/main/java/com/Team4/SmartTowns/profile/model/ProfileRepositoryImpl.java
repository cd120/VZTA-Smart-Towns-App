package com.Team4.SmartTowns.profile.model;

import com.Team4.SmartTowns.checkpoints.service.CheckpointService;
import com.Team4.SmartTowns.trails.model.Trail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileRepositoryImpl implements ProfileRepository {
    private JdbcTemplate jdbc;
    private RowMapper<Profile> profileMapper;

    private BCryptPasswordEncoder passwordEncoder;

    private CheckpointService checkpointService;

    @Autowired
    public ProfileRepositoryImpl(JdbcTemplate aJdbc, BCryptPasswordEncoder passwordEncoder, CheckpointService checkpointService) {
        this.jdbc = aJdbc;
        this.passwordEncoder = passwordEncoder;
        this.checkpointService = checkpointService;
        setProfileMapper();
    }

    private void setProfileMapper() {
        this.profileMapper = (resultSet, i) -> {
            Profile profile = new Profile();
            profile.setUserName(resultSet.getString("username"));
            profile.setCity(resultSet.getString("city"));
            profile.setAddress(resultSet.getString("address"));
            profile.setPassword(resultSet.getString("password"));
            profile.setAddress2(resultSet.getString("address2"));
            profile.setZipCode(resultSet.getString("zipCode"));
            profile.setEmail(resultSet.getString("email"));
            profile.setCheckpoints(checkpointService.getCheckpointsByUsername(resultSet.getString("username")));
            return profile;
        };
    }

    @Override
    public String saveProfile(Profile profile) {
        String encodedPassword = passwordEncoder.encode(profile.getPassword());
        String sql = "INSERT INTO user_table (username, password, enabled, email, address, address2, city, zipCode) VALUES (?, ?, ?, ? ,?,?,?,?) RETURNING username";
        String username = jdbc.queryForObject(sql, String.class, profile.getUserName(),encodedPassword, true, profile.getEmail(), profile.getAddress(), profile.getAddress2(), profile.getCity(),profile.getZipCode());
        String roles_sql = "insert into users_roles (username, role_id) values (?, 2) RETURNING username";
        jdbc.queryForObject(roles_sql, String.class, username);
        return username;
    }

    @Override
    public Profile findProfile(String username) {
        String sql = "SELECT * FROM user_table WHERE username = ?";
        return jdbc.queryForObject(sql, profileMapper, username);
    }


}
