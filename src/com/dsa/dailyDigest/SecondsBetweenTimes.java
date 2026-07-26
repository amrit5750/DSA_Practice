package com.dsa.dailyDigest;

public class SecondsBetweenTimes {
    public static void main(String[] args) {

        String startTime = "12:34:56";
        String endTime = "13:00:00";

        System.out.println(secondsBetweenTimes(startTime, endTime));

    }

    public static int secondsBetweenTimes(String startTime, String endTime) {

        int starthour = Integer.parseInt(startTime.split(":")[0]);
        int startmin = Integer.parseInt(startTime.split(":")[1]);
        int startSec = Integer.parseInt(startTime.split(":")[2]);

        int endHour = Integer.parseInt(endTime.split(":")[0]);
        int endMin = Integer.parseInt(endTime.split(":")[1]);
        int endSec = Integer.parseInt(endTime.split(":")[2]);

        int hourDiff = (endHour - starthour) * 60 * 60;
        int minDiff = (endMin - startmin) * 60;
        int secDiff = endSec - startSec;

        return hourDiff + minDiff + secDiff;

    }

}
