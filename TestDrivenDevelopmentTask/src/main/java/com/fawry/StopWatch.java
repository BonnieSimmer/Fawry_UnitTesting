package com.fawry;

public class StopWatch {
    private int minutes;
    private int hours;
    private int days;
    private boolean isWorkingHours;
    private final int DAILY_WORKING_HOURS = 8;

    public void record(int minutes) {
        if (minutes > 0) {
            this.minutes += minutes;
            if (this.minutes >= 60) {
                this.hours += this.minutes / 60;
                this.minutes = this.minutes % 60;
            }
            if (isWorkingHours) {
                if (this.hours >= DAILY_WORKING_HOURS) {
                    this.days += this.hours / DAILY_WORKING_HOURS;
                    this.hours = this.hours % DAILY_WORKING_HOURS;
                }
            }
            if (this.hours >= 24) {
                this.days += this.hours / 24;
                this.hours = this.hours % 24;
            }
        }
    }

    public int getMinutes() {
        return minutes;
    }
    public int getHours() {
       return hours;
    }
    public int getDays() {
        return days;
    }

    public void setWorkingHours(boolean state) {
        this.isWorkingHours = state;
    }
}
