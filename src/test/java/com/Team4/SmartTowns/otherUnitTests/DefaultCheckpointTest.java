package com.Team4.SmartTowns.otherUnitTests;

import com.Team4.SmartTowns.checkpoints.model.Checkpoint;
import com.Team4.SmartTowns.trails.model.Trail;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


//testng function createTempCheckpoint() works as intended, test passes.
public class DefaultCheckpointTest {

    @Test
    void testCreateTempCheckpoint() {

        // Arrange
        Trail testTrail = new Trail();
        testTrail.setId(1L);
        testTrail.setName("testTrailName");
        testTrail.setLocation("testTrailLocation");
        List<Checkpoint> initialCheckpoints = new ArrayList<>();
        initialCheckpoints.add(new Checkpoint(1L, "TestCheckpoint1", new double[]{1, 2}, "TestDescription1"));
        initialCheckpoints.add(new Checkpoint(2L, "TestCheckpoint2", new double[]{3, 4}, "TestDescription2"));
        testTrail.setCheckpoints(initialCheckpoints);
        testTrail.setDescription("testTrailDescription");

        //test - update the checkpoint
        int pos = 1; //index 1, TestCheckpoint2
        String name = "UpdatedCheckpoint";
        double latitude = 5;
        double longitude = 6;
        String description = "UpdatedDescription";

        // Act - calling the createTempCheckpoint() method
        createTempCheckpoint(testTrail, pos, name, description, latitude, longitude);
        System.out.println(testTrail);

        // Assert
        List<Checkpoint> testCheckpoints = testTrail.getCheckpoints();

        assertNotNull(testCheckpoints, "The updated checkpoints list should not be null");
        assertEquals(2, testCheckpoints.size(), "The size of the checkpoints list should remain the same");

        Checkpoint updatedCheckpoint = testCheckpoints.get(pos);
        System.out.println(updatedCheckpoint);

        assertNotNull(updatedCheckpoint, "The updated checkpoint should not be null");
        assertEquals(name, updatedCheckpoint.getName(), "The name should match the expected value");
        assertEquals(description, updatedCheckpoint.getDescription(), "The description should match the expected value");

        double[] expectedCoordinates = {latitude, longitude};
        assertArrayEquals(expectedCoordinates, updatedCheckpoint.getCoordinates(), "The coordinates should match the expected values");
    }

    private void createTempCheckpoint(Trail trail, int pos, String name, String description, double latitude, double longitude) {
        Checkpoint temp = new Checkpoint();
        temp.setName(name);
        temp.setDescription(description);
        temp.setCoordinates(new double[]{latitude, longitude});

        List<Checkpoint> tempList = new ArrayList<>(trail.getCheckpoints());
        tempList.set(pos, temp);
        trail.setCheckpoints(tempList);
    }

}
