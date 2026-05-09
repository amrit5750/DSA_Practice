package com.dsa.BinarySearch.BS1DArray;

public class FingSingleElementInSortedArray {

    public static void main(String[] args) {

        int[] nums = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };

        System.out.println(singleNonDuplicate(nums));

    }

    public static int singleNonDuplicate(int[] nums) {

        int element = 0;

        int low = 1;
        int high = nums.length - 2;

        if (nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;

        if (nums[0] != nums[1])
            return nums[0];
        if (nums[n - 1] != nums[n - 2])
            return nums[n - 1];

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            }

            if ((mid % 2 == 1 && nums[mid - 1] == nums[mid]) ||
                    (mid % 2 == 0 && nums[mid + 1] == nums[mid])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return element;

    }

}
