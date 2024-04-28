package com.Team4.SmartTowns.unitTests;


import com.Team4.SmartTowns.medals.model.Medal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class MedalTest {

//Testing whether the Lombok library actually automatically generates the class constructors with @AllArgsConstructor.

    @Test
    void testParameterisedConstructor() {
        // Arrange
        String medalName = "Gold";
        String medalDescription = "Awarded for reaching 60 checkpoints.";

        // Act
        Medal medal = new Medal(medalName, medalDescription);

        // Assert
        assertNotNull(medal);
        assertEquals(medalName, medal.getMedalName());
        assertEquals(medalDescription, medal.getMedalDescription());
    }

}

