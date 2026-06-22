package com.dsa.dailyDigest;

public class AngleClock {

    public static void main(String[] args) {

        int hour = 12;
        int minutes = 30;

        System.out.println(angleClock(hour, minutes));

    }

    public static double angleClock(int hour, int minutes) {

        double hourAngle = hour * 30 + minutes * 0.5;
        double minAngle = minutes * 6;

        double angle = Math.abs(hourAngle - minAngle);
        return Math.min(angle, 360 - angle);

    }

}
