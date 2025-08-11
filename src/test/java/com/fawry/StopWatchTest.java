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
        assertThat(minutes).isEqualTo(14); // RED
    }
}
