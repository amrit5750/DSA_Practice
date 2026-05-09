package com.dsa.strings.medium;

public class NextGreaterElementthree {

    public static void main(String[] args) {

        // int[] nums = { 1, 3, 5, 4, 2 };

        // {1,3,5,4,2}
        // {1,4,2,3,5} output

        System.out.println(nextGreaterElement(21));

    }

    public static void rotateArray(char[] arr, int left, int right) {

        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static int nextGreaterElement(int n) {

        char[] number = String.valueOf(n).toCharArray();

        int index = -1;

        for (int i = number.length - 2; i >= 0; i--) {
            if (number[i] < number[i + 1]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return -1;
        }

        for (int i = number.length - 1; i >= 0; i--) {
            if (number[i] > number[index]) {
                char temp = number[i];
                number[i] = number[index];
                number[index] = temp;
                break;

            }
        }

        rotateArray(number, index + 1, number.length - 1);
        long result = Long.parseLong(new String(number));

        return result > Integer.MAX_VALUE ? -1 : (int) result;

    }

}
