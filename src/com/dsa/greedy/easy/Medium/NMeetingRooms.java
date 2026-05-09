package com.dsa.greedy.easy.Medium;

import java.util.Arrays;
import java.util.Comparator;

public class NMeetingRooms {

    public static void main(String[] args) {

        int[] Start = { 1, 3, 0, 5, 8, 5 };
        int[] end = { 2, 4, 6, 7, 9, 9 };

        System.out.println(getMeetingCount(Start, end));

    }

    public static int getMeetingCount(int[] start, int[] end) {
        int count = 0;

        MeetingDS[] meetings = new MeetingDS[start.length];

        for (int i = 0; i < meetings.length; i++) {
            meetings[i] = new MeetingDS(start[i], end[i], i + 1);
        }

        Arrays.sort(meetings, Comparator.comparingInt(m -> m.endTime));

        int freeTime = meetings[0].endTime;

        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i].startTime > freeTime) {
                count++;
                freeTime = meetings[i].endTime;
            }
        }

        return count + 1;

    }

}

class MeetingDS {

    public int startTime;
    public int endTime;
    public int postion;

    MeetingDS(int startTime, int endTime, int postion) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.postion = postion;
    }
}
