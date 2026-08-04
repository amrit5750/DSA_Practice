package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class AggregateTimeSeries {

    public static void main(String[] args) {

        int[][] series1 = { { 1, 3 }, { 4, 1 } };
        int[][] series2 = { { 2, 2 }, { 5, 2 } };
        System.out.println(aggregateTimeSeries(series1, series2));

    }

    public static List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {

        Set<Integer> distinctTimeStamps = new TreeSet<>();

        TreeMap<Integer, Integer> series1Map = new TreeMap<>();
        TreeMap<Integer, Integer> series2Map = new TreeMap<>();

        List<List<Integer>> result = new ArrayList<>();

        // Populate series1
        for (int[] pair : series1) {
            distinctTimeStamps.add(pair[0]);
            series1Map.put(pair[0], pair[1]);
        }

        // Populate series2
        for (int[] pair : series2) {
            distinctTimeStamps.add(pair[0]);
            series2Map.put(pair[0], pair[1]);
        }

        for (Integer timeStamp : distinctTimeStamps) {

            int value = 0;

            Map.Entry<Integer, Integer> e1 = series1Map.ceilingEntry(timeStamp);
            if (e1 != null) {
                value += e1.getValue();
            }

            Map.Entry<Integer, Integer> e2 = series2Map.ceilingEntry(timeStamp);
            if (e2 != null) {
                value += e2.getValue();
            }

            List<Integer> row = new ArrayList<>();
            row.add(timeStamp);
            row.add(value);

            result.add(row);
        }

        return result;

    }

}
