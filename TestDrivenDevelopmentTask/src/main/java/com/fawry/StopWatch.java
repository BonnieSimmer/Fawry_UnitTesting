package com.fawry;

public class StopWatch {
    private int minutes;
    private int hours;

    public void record(int minutes) {
        if (minutes > 0) {
            this.minutes += minutes;
        }
    }

    public int getMinutes() {
        return minutes;
    }
    public int getHours() {
       return 0;
    }

}
