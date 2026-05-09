package com.dsa.BinarySearch.BSOnAnswers;

public class KthMissingNumber {

    public static void main(String[] args) {

        int[] nums = { 2, 3, 4, 7, 11 };

        // (0,1,2,3,4) // index
        // 1,1,1,3,6 // missing number
        // 2,3,4,7,11 // nums

        // nums[i] -(i+1) == to get the number of elements missing at given i

        // when you will be at 7 , then high will to it and you need 2 more missing
        // numbers and low will be pointing to 11.

        // so , it will be high + more;

        // now more = k-missing;

        // int missing = nums[high] - (high + 1);

        // so , arr[high] + k - nums[high] +high + 1;

        // high+k+1;

        // or low = high+1;

        System.out.println(findKthPositive(nums, 5));

    }

    public static int findKthPositive(int[] nums, int k) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int missing = nums[mid] - (mid + 1);

            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return low + k;

    }

    public static int findKthPositiveBruteForce(int[] arr, int k) {

        int num = k;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= num) {
                num++;
            } else {
                break;
            }
        }

        return num;

    }

}
