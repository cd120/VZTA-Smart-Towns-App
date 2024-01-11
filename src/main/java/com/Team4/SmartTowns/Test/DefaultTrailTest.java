package com.Team4.SmartTowns.Test;


import org.junit.jupiter.api.Test;
import com.Team4.SmartTowns.trails.model.Trail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class DefaultTrailTest {

    @Test
    void testCreateTempTrail() {
        // Arrange
        String name = "Test Trail";
        String location = "Test Location";
        String description = "Test Description";

        // Act - calling the createTempTrail() method
        Trail tempTrail = createTempTrail(name, location, description);

        // Assert - verifying the answer
        assertNotNull(tempTrail);
        assertEquals(name, tempTrail.getName());
        assertEquals(location, tempTrail.getLocation());
        assertEquals(description, tempTrail.getDescription());
    }

    // createTempTrail method included
    private Trail createTempTrail(String name, String location, String description) {

        Trail tempTrail = new Trail();
        tempTrail.setName(name);
        tempTrail.setLocation(location);
        tempTrail.setDescription(description);
        return tempTrail;
    }
}


