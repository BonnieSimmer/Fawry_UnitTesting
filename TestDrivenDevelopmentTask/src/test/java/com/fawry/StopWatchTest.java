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
        stopWatch.record(14);
        int minutes = stopWatch.getMinutes();
        assertThat(minutes).isEqualTo(14); // GREEN
    }

    // negative input should be ignored
    @Test
    void shouldIgnoreNegativeMinutes() {
        stopWatch.record(-5);
        int minutes = stopWatch.getMinutes();
        assertThat(minutes).isEqualTo(0); // GREEN
    }

    // if minutes reached 60 it should increase hours
    @Test
    void shouldIncreaseHoursWhenMinutesReachSixty() {
        stopWatch.record(64);
        int minutes = stopWatch.getMinutes();
        int hours = stopWatch.getHours();
        assertThat(minutes).isEqualTo(4); // GREEN
        assertThat(hours).isEqualTo(1); // GREEN
    }
}
