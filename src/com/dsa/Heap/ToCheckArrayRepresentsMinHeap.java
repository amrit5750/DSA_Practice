package com.dsa.Heap;

public class ToCheckArrayRepresentsMinHeap {

    public static void main(String[] args) {

        int[] arr = { 10, 20, 30, 21, 23 };
        System.out.println(isMinHeap(arr));
    }

    public static boolean isMinHeap(int[] arr) {

        for (int i = 0; i <= arr.length / 2; i++) {

            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < arr.length && arr[left] < arr[i]) {
                return false;
            }

            if (right < arr.length && arr[right] < arr[i]) {
                return false;
            }
        }
        return true;

    }

}
