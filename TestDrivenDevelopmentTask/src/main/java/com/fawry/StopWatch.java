package com.fawry;

public class StopWatch {
    private int minutes;
    private int hours;
    private int days;
    private boolean isWorkingHours;
    private final int DAILY_WORKING_HOURS = 8;

    public void record(int minutes) {
        if (minutes <= 0) return;

        this.minutes += minutes;
        if (this.minutes >= 60) {
            this.hours += this.minutes / 60;
            this.minutes %= 60;
        }

        int hoursPerDay = isWorkingHours ? DAILY_WORKING_HOURS : 24;
        if (this.hours >= hoursPerDay) {
            this.days += this.hours / hoursPerDay;
            this.hours %= hoursPerDay;
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
