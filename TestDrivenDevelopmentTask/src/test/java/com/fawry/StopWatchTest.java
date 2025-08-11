package com.fawry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StopWatchTest {
    private StopWatch stopWatch;

    @BeforeEach
    void setUp() {
        stopWatch = new StopWatch();
    }

    // Create a stopwatch that records minutes
    @Test
    void shouldRecordMinutes() {
        // Arrange & Act
        stopWatch.record(14);
        int minutes = stopWatch.getMinutes();

        // Assert
        assertThat(minutes).isEqualTo(14); // GREEN
    }

    // negative input should be ignored
    @Test
    void shouldIgnoreNegativeMinutes() {
        // Arrange & Act
        stopWatch.record(-5);
        int minutes = stopWatch.getMinutes();

        // Assert
        assertThat(minutes).isEqualTo(0); // GREEN
    }

    // if minutes reached 60 it should increase hours
    @Test
    void shouldIncreaseHoursWhenMinutesReachSixty() {
        // Arrange & Act
        stopWatch.record(64);
        int minutes = stopWatch.getMinutes();
        int hours = stopWatch.getHours();

        // Assert
        assertThat(minutes).isEqualTo(4); // GREEN
        assertThat(hours).isEqualTo(1); // GREEN
    }

    // if hours reached 24 it should increase days
    @Test
    void shouldIncreaseDaysWhenHoursReachTwentyFour() {
        // Arrange & Act
        stopWatch.record(1635); // 27 hours and 15 minutes = 1635 minutes
        int minutes = stopWatch.getMinutes();
        int hours = stopWatch.getHours();
        int days = stopWatch.getDays();

        // Assert
        assertThat(minutes).isEqualTo(15); // RED
        assertThat(hours).isEqualTo(3); // RED
        assertThat(days).isEqualTo(1); // RED
    }
}
