package com.dsa.GoldmanSaches.Easy;

public class JudgeCircle {
    public static void main(String[] args) {
        String moves = "UD";
        System.out.println(judgeCircle(moves));

    }

    public static boolean judgeCircle(String moves) {

        int horizontal = 0;
        int vertical = 0;

        for (int i = 0; i < moves.length(); i++) {

            if (moves.charAt(i) == 'L') {
                horizontal--;
            } else if (moves.charAt(i) == 'R') {
                horizontal++;
            } else if (moves.charAt(i) == 'U') {
                vertical++;
            } else if (moves.charAt(i) == 'D') {
                vertical--;
            }
        }
        return vertical == 0 && horizontal == 0;

    }

}
