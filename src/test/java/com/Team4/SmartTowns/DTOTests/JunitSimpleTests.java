package com.Team4.SmartTowns.DTOTests;

import com.Team4.SmartTowns.medals.model.Medal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class JunitSimpleTests {

    @Test
    void DTOTest() {
        // Arrange
        String medalName = "Gold";
        String medalDescription = "60 checkpoints";
        Medal medal = new Medal();

        // Act
        medal.setMedalName(medalName);
        medal.setMedalDescription(medalDescription);

        // Assert
        assertEquals(medal.getMedalName(), "Gold");
        assertEquals(medal.getMedalDescription(), "60 checkpoints");
    }

}
