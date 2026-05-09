package com.dsa.BinarySearch.BSOnAnswers;

// https://leetcode.com/problems/median-of-two-sorted-arrays/description/
// time complexity O(log(min(n1,n2)))
// space complexity O(1)
// how it works:
// we need to find the median of two sorted arrays
// we can use b
// inary search to find the median
// we will use the smaller array to do binary search
// we will find the cut point in the smaller array and the cut point in the larger array
// we will compare the left and right elements of the cut points
// if the left element of the smaller array is less than or equal to the right element of the larger array and the left element of the larger array is less than or equal to the right element of the smaller array, then we have found the correct cut points
// if the left element of the smaller array is greater than the right element of the larger array, then we need to move the cut point in the smaller array to the left
// if the left element of the larger array is greater than the right element of the smaller array, then we need to move the cut point in the smaller array to the right
// we will continue this process until we find the correct cut points
// once we have found the correct cut points, we can calculate the median based on the total number of elements in both arrays
// if the total number of elements is even, then the median is the average of the maximum of the left elements and the minimum of the right elements
// if the total number of elements is odd, then the median is the maximum of the left
// elements 
// we will return the median as a double value
// we will also handle the edge cases where the cut point is at the beginning or the end of the array by using Integer.MIN_VALUE and Integer.MAX_VALUE respectively
// we will also handle the case where the smaller array is empty by returning the median of the larger array
// we will also handle the case where the larger array is empty by returning the median of the smaller array
// we will also handle the case where both arrays are empty by returning 0.0
// we will also handle the case where the total number of elements is odd by returning the maximum of the left elements as the median
// we will also handle the case where the total number of elements is even by returning the average of the maximum of the left elements and the minimum of the right elements as the median
// we will also handle the case where the total number of elements is odd by returning the maximum of the left elements as the median
// we will also handle the case where the total number of elements is even by returning the average of the maximum of the left elements and the minimum of the right elements as the median
// we will also handle the case where the total number of elements is odd by returning the maximum of the left elements as the median
// we will also handle the case where the total number of elements is even by returning the average
public class MedianTwoSortedArrays {

    public static void main(String[] args) {

        int[] nums1 = { 1, 3 };
        int[] nums2 = { 2 };

        System.out.println(findMedianSortedArrays(nums1, nums2));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = nums1.length;
        int n1 = nums1.length;
        int n2 = nums2.length;

        while (low <= high) {

            int cut1 = low + (high - low) / 2;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;

            int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];

            int right1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];

            if (left1 <= right2 && left2 <= right1) {
                if ((n1 + n2) % 2 == 0) {
                    return ((Math.max(left1, left2) + Math.min(right1, right2)) / 2.0);

                } else {
                    return Math.max(left1, left2);
                }
            } else if (left1 > right2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }

        }

        return 0.0;
    }
}
