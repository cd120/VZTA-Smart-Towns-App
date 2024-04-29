package com.Team4.SmartTowns.otherUnitTests;

import org.junit.jupiter.api.Test;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedalDeterminerTest {

    // testing helper method determineMedal works as intended, test passes.
    public static class MedalDeterminer {

        private int sumCheckpoints;

        public void setSumCheckpoints(int sumCheckpoints) {
            this.sumCheckpoints = sumCheckpoints;
        }

        public int getSumCheckpoints() {
            return sumCheckpoints;
        }

        private String determineMedal() {

            if (sumCheckpoints >= 60) {
                return "GOLD";
            } else if (sumCheckpoints >= 40) {
                return "SILVER";
            } else if (sumCheckpoints >= 20) {
                return "BRONZE";
            } else {
                return "none";
            }
        }

        @Test
        public void testDetermineMedalGold() {

            // Arrange
            MedalDeterminer medalDeterminer = new MedalDeterminer();
            medalDeterminer.setSumCheckpoints(61);

            // Act
            String result = medalDeterminer.determineMedal();

            // Assert
            assertNotNull(result, "Result should not be null");
            assertEquals("GOLD", result,"GOLD should match the expected result" );
            assertEquals(61, medalDeterminer.getSumCheckpoints(), "Value should match the expected result");
        }

        @Test
        public void testDetermineMedalSilver() {

            // Arrange
            MedalDeterminer medalDeterminer = new MedalDeterminer();
            medalDeterminer.setSumCheckpoints(45);

            // Act
            String result = medalDeterminer.determineMedal();

            // Assert
            assertEquals("SILVER", result);
            assertEquals(45, medalDeterminer.getSumCheckpoints());
        }

        @Test
        public void testDetermineMedalBronze() {

            // Arrange
            MedalDeterminer medalDeterminer = new MedalDeterminer();
            medalDeterminer.setSumCheckpoints(28);

            // Act
            String result = medalDeterminer.determineMedal();

            // Assert
            assertEquals("BRONZE", result);
            assertEquals(28, medalDeterminer.getSumCheckpoints());
        }
    }
//Testing other possibilities:

//        public String giveGold() {
//            return "Gold";
//        }
//
//        public String giveSilver() {
//            return "Silver";
//        }
//
//        public String giveBronze() {
//            return "Bronze";
//        }
//
//        public String determineMedal() {
//            if (sumCheckpoints >= 60) {
//                giveGold();
//            }
//            if (sumCheckpoints >= 40) {
//                giveSilver();
//            }
//            if (sumCheckpoints >= 20) {
//                giveBronze();
//            }
//            return "";
//        }
}
