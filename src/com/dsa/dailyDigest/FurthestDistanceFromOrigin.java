package com.dsa.dailyDigest;

public class FurthestDistanceFromOrigin {
    public static void main(String[] args) {

        String moves = "L_RL__R";
        System.out.println(furthestDistanceFromOrigin(moves));

    }

    public static int furthestDistanceFromOrigin(String moves) {
        int left = 0;
        int right = 0;
        int dash = 0;

        for (int i = 0; i < moves.length(); i++) {

            if ((moves.charAt(i) == 'L')) {
                left++;

            } else if (moves.charAt(i) == 'R') {
                right++;
            } else {
                dash++;
            }
        }
        return Math.abs(left - right) + dash;
    }

}
