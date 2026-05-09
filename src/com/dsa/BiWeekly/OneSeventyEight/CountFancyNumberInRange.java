package com.dsa.BiWeekly.OneSeventyEight;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountFancyNumberInRange {

    static List<Long> fancyNumber = new ArrayList<>();

    public static void main(String[] args) {

        long l = 12340;
        long r = 12341;
        System.out.println(countFancy(l, r));

    }

    public static long countFancy(long l, long r) {

        fancyNumber.clear();

        int count = 0;

        for (int i = 1; i <= 9; i++) {
            generateIncreasing(i, i, r);
        }

        for (int i = 9; i >= 0; i++) {
            generateDecreasing(i, i, r);
        }
        Set<Long> set = new HashSet<>(fancyNumber);
        for (Long num : set) {
            if (num >= l && num <= r) {
                count++;
            }
        }
        return count;
    }

    public static void generateIncreasing(int lastDigit, long num, long r) {

        if (num > r) {
            return;
        }
        fancyNumber.add(num);
        for (int i = lastDigit + 1; i <= 9; i++) {
            generateIncreasing(i, num * 10 + i, r);
        }

    }

    public static void generateDecreasing(int lastDigit, long num, long r) {
        if (num > r) {
            return;
        }
        fancyNumber.add(num);
        for (int i = lastDigit - 1; i >= 0; i--) {
            generateDecreasing(i, num * 10 + i, r);
        }
    }
}

// ================

// class Solution {
// public long countFancy(long l, long r) {
// int count = 0;

// for (long i = l; i <= r; i++) {
// if (i < 9) {
// count++;
// } else {
// int[] arr = String.valueOf(i).chars().map(c -> c - '0').toArray();
// if (isDecreasingOrder(arr) || isIncreasingOrder(arr)) {
// count++;
// } else {
// int sum = Arrays.stream(arr).sum();
// int[] sumArr = String.valueOf(sum).chars().map(c -> c - '0').toArray();
// if (isDecreasingOrder(sumArr) || isIncreasingOrder(sumArr)) {
// count++;
// }
// }

// }

// }

// return count;

// }

// public static boolean isDecreasingOrder(int[] arr) {

// for (int i = 1; i < arr.length; i++) {
// if (arr[i - 1] <= arr[i]) {
// return false;
// }
// }
// return true;
// }

// public static boolean isIncreasingOrder(int[] arr) {

// for (int i = 1; i < arr.length; i++) {
// if (arr[i - 1] >= arr[i]) {
// return false;
// }

// }
// return true;
// }
// }