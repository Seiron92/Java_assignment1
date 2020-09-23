/*
 * Date: 2020-09-17
 * File rj222nq_assign1.java
 * Author: Rebecca Seiron
 * 
 */
package rj222nq_assign1;

public class Time {

    private int hour;
    private int minute;
    private int second;

    // Getters
    public int getHour() {
        return this.hour;
    }
    public int getMinute() {
        return this.minute;
    }
    public int getSecond() {
        return this.second;
    }
    
    // Setters
    public void setHour(int hours) {
        this.hour = hours;
    }
    public void setMinute(int minutes) {
        this.minute = minutes;
    }

    public void setSecond(int seconds) {
        this.second = seconds;
    }
    
    // Add a 0 to hour/minute/second if the number is less than 10
    public String toString() {

        String timeFill = "";
        if (hour < 10)
            timeFill += "0";
        timeFill += hour + ":";

        if (minute < 10)
            timeFill += "0";
        timeFill += minute + ":";

        if (second < 10)
            timeFill += "0";
        timeFill += second;

        return timeFill;

    }
    // If nothing is "determine" the hour/minute/second = 0
    public Time() {
        hour = 0;
        minute = 0;
        second = 0;
    }

    public Time(int hours,
        int minutes,
        int seconds) {
    	
    	// If seconds are less than 0 or more than 59 alert (exception) the user about the "problem"
        if (seconds < 0 || seconds > 59) {
            throw new IllegalArgumentException("Seconds can only be the maximum of 59, " + seconds + " is not valid");
        } else {
            second = seconds;
        }
    	// If minutes are less than 0 or more than 59 alert (exception) the user about the "problem"
        if (minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Minutes can only be the maximum of 59, " + minutes + " is not valid");
        } else {
            minute = minutes;
        }
    	// If hours are less than 0 or more than 23 alert (exception) the user about the "problem"
        if (hours < 0 || hours > 23) {
            throw new IllegalArgumentException("Hours can only be the maximum of 23, " + hours + " is not valid");
        } else {
            hour = hours;
        }

    }
    // Convert the time to seconds
    // Credit: https://www.geeksforgeeks.org/converting-seconds-into-days-hours-minutes-and-seconds/
    public static void setClock(int second) {

        second = second % (24 * 3600);
        int hour = second / 3600;

        second %= 3600;
        int minutes = second / 60;

        second %= 60;
        int seconds = second;
        // Probably redundant (isn't a part of the requirements but I though it looked nicer when the time is  formatted
        String timeFill = "";
        if (hour < 10)
            timeFill += "0";
        timeFill += hour + ":";

        if (minutes < 10)
            timeFill += "0";
        timeFill += minutes + ":";

        if (second < 10)
            timeFill += "0";
        timeFill += seconds;

        System.out.println(timeFill);
    }

    public static void main(String[] args) {
    	/* Remove the comments to test the code */

        Time times = new Time(02, 00, 00);
        System.out.println(times.toString());
        //times.tickDown();
        //times.tick();

        /* For the addTime() && subtracTime() */
        Time otherTime = new Time(23, 00, 00);
        // times.subtracTime(otherTime);
        // times.addTime(otherTime);

    }

    public int tick() {
    	// Get hour/minute/time from the time object
        int second = getSecond();
        int minute = getMinute();
        int hour = getHour();
        // Convert it to seconds
        int timeInSeconds = second + (minute * 60) + (hour * 3600);

        while (true) {
            try {
                timeInSeconds++; // add itself (second) to the "ticker"
                setClock(timeInSeconds); // Pass it to the "setClock-method"
                Thread.sleep(1000); // Initialize thread sleep (the "interval" something should happen"

            } catch (InterruptedException e1) {
                e1.printStackTrace(); // If error, throw exception
            }
        }
    }

    public int tickDown() {
    	// Get hour/minute/time from the time object
        int second = getSecond();
        int minute = getMinute();
        int hour = getHour();
        // Convert it to seconds
        int timeInSeconds = second + (minute * 60) + (hour * 3600);

        while (true) {
            try {
                timeInSeconds--; // remove 1 (second) to the "ticker"
                setClock(timeInSeconds); // Pass it to the "setClock-method"
                Thread.sleep(1000); // Initialize thread sleep (the "interval" something should happen"

            } catch (InterruptedException e1) {
                e1.printStackTrace(); // If error, throw exception
            }
        }
    }
    
    public void addTime(Time x) {
    	// Get hour/minute/time from the time object
        int second = getSecond();
        int minute = getMinute();
        int hour = getHour();
        // Convert the original time in to seconds
        int originalTimeInSeconds = second + (minute * 60) + (hour * 3600);
        // Get hour/minute/time from the new "input"
        int second2 = x.second;
        int minute2 = x.minute;
        int hour2 = x.hour;
        // Convert the new time in to seconds
        int newTimeInSeconds = second2 + (minute2 * 60) + (hour2 * 3600);
        // Add the new time to the original time
        int times = originalTimeInSeconds + newTimeInSeconds;
        // pass it to the "setClock-method"
        setClock(times);
    }
    
    public void subtracTime(Time x) {
    	// Get hour/minute/time from the time object
        int second = getSecond();
        int minute = getMinute();
        int hour = getHour();
        // Convert the original time in to seconds
        int originalTimeInSeconds = second + (minute * 60) + (hour * 3600);
        // Get hour/minute/time from the new "input"
        int second2 = x.second;
        int minute2 = x.minute;
        int hour2 = x.hour;
        // Convert the new time in to seconds
        int newTimeInSeconds = second2 + (minute2 * 60) + (hour2 * 3600);
        // Subtract the new time from the original time
        int times = originalTimeInSeconds - newTimeInSeconds;
        // pass it to the "setClock-method"
        setClock(times);
    }
}