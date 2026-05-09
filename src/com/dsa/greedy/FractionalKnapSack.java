package com.dsa.greedy;

import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value;
    int weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public static Comparator<Item> vComparator = new Comparator<Item>() {

        @Override
        public int compare(Item o1, Item o2) {

            double ratio1 = (double) o1.value / o1.weight;
            double ratio2 = (double) o2.value / o2.weight;

            return Double.compare(ratio2, ratio1);
        }
    };
}

public class FractionalKnapSack {

    public static void main(String[] args) {
        int[] values = { 60, 100, 120 };
        int[] weights = { 10, 20, 30 };
        int capacity = 50;

        double maxValue = getMaxValue(values, weights, capacity);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }

    public static double getMaxValue(int[] values, int[] Weight, int capacity) {

        Item[] arr = new Item[values.length];

        int currentWeight = 0;
        double finalValue = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Item(values[i], Weight[i]);
        }

        Arrays.sort(arr, Item.vComparator);

        for (int i = 0; i < arr.length; i++) {

            if (currentWeight + arr[i].weight <= capacity) {
                currentWeight += arr[i].weight;
                finalValue += arr[i].value;
            } else {
                int rem = capacity - currentWeight;
                finalValue += (arr[i].value / (double) arr[i].weight) * (double) rem;
                break;
            }

        }

        return finalValue;

    }

}
