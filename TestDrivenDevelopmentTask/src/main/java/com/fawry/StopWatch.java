package com.fawry;

public class StopWatch {
    private int minutes;
    private int hours;

    public void record(int minutes) {
        if (minutes > 0) {
            this.minutes += minutes;
            if (this.minutes >= 60) {
                this.hours += this.minutes / 60;
                this.minutes = this.minutes % 60;
            }
        }
    }

    public int getMinutes() {
        return minutes;
    }
    public int getHours() {
       return hours;
    }

}
