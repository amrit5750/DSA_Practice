package com.dsa.dailyDigest;

public class getHappyString {

    static int counter = 0;
    static String result = "";

    public static void main(String[] args) {

        System.out.println(getHappy(1, 3));

    }

    public static void solve(int n, int k, String current) {

        if (!result.isEmpty())
            return;

        if (current.length() == n) {
            counter++;
            if (counter == k) {
                result = current;
            }
            return;
        }

        for (char ch = 'a'; ch <= 'c'; ch++) {

            if (current.length() > 0 && current.charAt(current.length() - 1) == ch) {
                continue;
            }
            solve(n, k, current + ch);
        }
    }

    public static String getHappy(int n, int k) {
        counter = 0;
        result = "";

        solve(n, k, "");
        return result;

    }

}
