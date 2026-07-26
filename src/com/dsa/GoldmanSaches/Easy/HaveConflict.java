package com.dsa.GoldmanSaches.Easy;

public class HaveConflict {
    public static void main(String[] args) {

        String[] event1 = { "01:15", "02:00" };
        String[] event2 = { "02:00", "03:00" };
        System.out.println(haveConflict(event1, event2));

    }

    public static boolean haveConflict(String[] event1, String[] event2) {

        return event1[0].compareTo(event2[1]) <= 0 &&
                event2[0].compareTo(event1[1]) <= 0;

    }
}
