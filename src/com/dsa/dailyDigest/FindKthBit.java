package com.dsa.dailyDigest;

public class FindKthBit {

    public static void main(String[] args) {

        int n = 3, k = 1;
        System.out.println(findKthBit(n, k));

    }

    public static char findKthBitOptimal(int n, int k) {
        if (n == 1)
            return '0';

        int len = (1 << n) - 1;
        int mid = (len / 2) + 1;

        if (k == mid)
            return '1';
        if (k < mid)
            return findKthBitOptimal(n - 1, k);

        // mirror position
        char bit = findKthBitOptimal(n - 1, len - k + 1);
        return bit == '0' ? '1' : '0';
    }

    public static char findKthBit(int n, int k) {

        return findKthBitHelper(n).charAt(k - 1);

    }

    public static String findKthBitHelper(int n) {
        return StringGenerator("0", 0, n);
    }

    public static String StringGenerator(String str, int initialCount, int finalCount) {

        if (initialCount == finalCount) {
            return str;
        }

        str = str + "1" + new StringBuilder(inverse(str)).reverse().toString();
        return StringGenerator(str, initialCount + 1, finalCount);

    }

    public static String inverse(String str) {

        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '1') {
                ch[i] = '0';
            } else {
                ch[i] = '1';
            }

        }

        return new String(ch);

    }

}
