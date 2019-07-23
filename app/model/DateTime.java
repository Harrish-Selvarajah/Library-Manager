package model;

public class DateTime {
    private int Hours;
    private int minutes;
    private int seconds;

    public DateTime(int Hours, int minutes, int seconds){
        this.Hours=Hours;
        this.minutes=minutes;
        this.seconds=seconds;
    }

    public int getHours() {
        return Hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
}
