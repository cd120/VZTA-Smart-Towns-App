package com.Team4.SmartTowns.defaultTests;

import com.Team4.SmartTowns.checkpoints.model.Checkpoint;
import com.Team4.SmartTowns.checkpoints.service.CheckpointService;
import com.Team4.SmartTowns.medals.service.MedalService;
import com.Team4.SmartTowns.profile.service.ProfileService;
import com.Team4.SmartTowns.testscripts.DefaultsGeneratorImpl;
import com.Team4.SmartTowns.trails.model.Trail;
import com.Team4.SmartTowns.trails.service.TrailService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class DefaultsGeneratorImplTest {
    private TrailService trailService;
    private CheckpointService checkpointService;
    private ProfileService profileService;
    private MedalService medalService;

    @Test
    void testCreateTempTrail() {
        // test the temporary trail generation
        System.out.println("Testing temp trail generation...");

        DefaultsGeneratorImpl defaultsGenerator = new DefaultsGeneratorImpl(trailService, checkpointService, profileService, medalService);

        String name = "Test Trail";
        String location = "Test Location";
        String description = "Test Description";

        Trail tempTrail = defaultsGenerator.createTempTrail(name, location, description);

        // test that trail is actually created, with each field being assigned correctly
        assert tempTrail != null;
        assert tempTrail.getName().equals(name);
        assert tempTrail.getLocation().equals(location);
        assert tempTrail.getDescription().equals(description);
        System.out.println("Temp trail generation tests passed!");
    }

    @Test
    void testCreateTempCheckpoint() {
        // test temporary checkpoint creation, on an existing trail
        System.out.println("Testing temp checkpoint generation...");

        DefaultsGeneratorImpl defaultsGenerator = new DefaultsGeneratorImpl(trailService, checkpointService, profileService, medalService);

        Trail trail = new Trail();

        // initialize checkpoint values
        int pos = 0;
        String name = "Test Checkpoint";
        String description = "Test Description";
        double latitude = 0.0;
        double longitude = 0.0;

        defaultsGenerator.createTempCheckpoint(trail, pos, name, description, latitude, longitude);

        // check that the checkpoint contains the relevant values, and has been placed in the correct positions
        assert trail.getCheckpoints().size() == 20;
        Checkpoint checkpoint = trail.getCheckpoints().get(0);
        assert checkpoint != null;
        assert checkpoint.getName().equals(name);
        assert checkpoint.getDescription().equals(description);
        assert checkpoint.getCoordinates()[0] == latitude;
        assert checkpoint.getCoordinates()[1] == longitude;
        System.out.println("Temp checkpoint generation passed!");
    }

    @Test
    void testAddMultipleCheckpointsToTrail() {
        // test the multiple checkpoint generator
        System.out.println("Testing multiple checkpoints generation...");

        DefaultsGeneratorImpl defaultsGenerator = new DefaultsGeneratorImpl(trailService, checkpointService, profileService, medalService);

        Trail trail = new Trail();

        int start = 0;
        defaultsGenerator.addMultipleCheckpointsToTrail(trail, start);

        // check that the correct amount of checkpoints has been generated (which should be no more or less than 20)
        assert trail.getCheckpoints().size() == 20;

        System.out.println("Multiple checkpoint generation passed!");
    }
}