package com.dsa.Heap;

import java.util.Arrays;

public class ConvertMinToMax {

    public static void main(String[] args) {

        int[] arr = { 10, 20, 30, 21, 23 };

        System.out.println(Arrays.toString(mintoMax(arr)));

    }

    public static void heapifyMax(int arr[], int n, int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[largest] < arr[left]) {
            largest = left;
        }
        if (right < n && arr[largest] < arr[right]) {
            largest = right;

        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapifyMax(arr, n, largest);
        }
    }

    public static int[] mintoMax(int[] arr) {

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapifyMax(arr, arr.length, i);
        }
        return arr;

    }

}
