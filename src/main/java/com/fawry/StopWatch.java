package com.fawry;

public class StopWatch {
    private int minutes;

    public void record(int minutes) {
        this.minutes += minutes;
    }

    public int getMinutes() {
        return minutes;
    }

}
