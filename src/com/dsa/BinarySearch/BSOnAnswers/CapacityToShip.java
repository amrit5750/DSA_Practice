package com.dsa.BinarySearch.BSOnAnswers;

public class CapacityToShip {

    public static void main(String[] args) {

        int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        int days = 5;

        System.out.println(getWeightCapacity(weights, days));

    }

    public static int getWeightCapacity(int[] weights, int days) {

        int low = 0, high = 0;
        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int dayrequired = getNumberOfDays(weights, mid);

            if (dayrequired <= days) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;

    }

    public static int getNumberOfDays(int[] weights, int CapacityToShip) {

        int days = 1;

        int currentWeigh = 0;

        for (int weight : weights) {

            if (currentWeigh + weight > CapacityToShip) {
                days++;
                currentWeigh = weight;
            } else {
                currentWeigh += weight;
            }
        }

        return days;

    }

}
