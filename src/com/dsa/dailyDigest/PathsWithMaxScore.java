package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.List;

public class PathsWithMaxScore {

    public static void main(String[] args) {

        List<String> ls = new ArrayList<>();
        ls.add("E23");
        ls.add("2X2");
        ls.add("12S");

        System.out.println(pathsWithMaxScore(ls));

    }

    public static int getIntfromChar(char ch) {

        return ch != 'S' ? ch - '0' : 0;

    }

    public static Pair solve(int i, int j, List<String> board) {

        int m = board.size();
        int n = board.get(0).length();

        if (board.get(i).charAt(j) == 'E') {
            return new Pair(0, 1);
        }

        if (board.get(i).charAt(j) == 'X') {
            return new Pair(0, 0);
        }

        int upScore = 0;
        int upPaths = 0;
        int leftScore = 0;
        int leftPaths = 0;
        int diagonalScore = 0;
        int diagonalPaths = 0;

        char ch = board.get(i).charAt(j);
        if (isValid(i - 1, j, m, n, ch)) {
            Pair upPair = solve(i - 1, j, board);
            upScore = upPair.score;
            upPaths = upPair.Path;

            if (upPaths > 0) {
                upScore += getIntfromChar(ch);

            }
        }

        if (isValid(i, j - 1, m, n, ch)) {
            Pair leftPair = solve(i, j - 1, board);
            leftScore = leftPair.score;
            leftPaths = leftPair.Path;

            if (leftPaths > 0) {
                leftScore += getIntfromChar(ch);

            }
        }
        if (isValid(i - 1, j - 1, m, n, ch)) {
            Pair diaPair = solve(i - 1, j - 1, board);
            diagonalScore = diaPair.score;
            diagonalPaths = diaPair.Path;

            if (diagonalPaths > 0) {
                diagonalScore += getIntfromChar(ch);
            }
        }

        int bestScore = 0;
        int bestPaths = 0;

        if (upScore == leftScore && leftScore == diagonalScore) {
            bestScore = leftScore;
            bestPaths = upPaths + leftPaths + diagonalPaths;
        } else if (upScore == leftScore) {
            bestScore = upScore;
            bestPaths = upPaths + leftPaths;

            if (diagonalScore > bestScore || (diagonalScore == bestScore && diagonalPaths > bestPaths)) {
                bestScore = diagonalScore;
                bestPaths = diagonalPaths;
            }
        } else if (leftScore == diagonalScore) {
            bestScore = leftScore;
            bestPaths = leftPaths + diagonalPaths;

            if (upScore > bestScore || (upScore == bestScore && upPaths > bestPaths)) {
                bestScore = upScore;
                bestPaths = upPaths;
            }
        } else {
            bestScore = upScore;
            bestPaths = upPaths;
            if (leftScore > bestScore || (leftScore == bestScore && leftPaths > bestPaths)) {
                bestScore = leftScore;
                bestPaths = leftPaths;
            }
            if (diagonalScore > bestScore || (diagonalScore == bestScore && diagonalPaths > bestPaths)) {
                bestScore = diagonalScore;
                bestPaths = diagonalPaths;
            }

        }

        return new Pair(bestScore, bestPaths);

    }

    public static int[] pathsWithMaxScore(List<String> board) {

        int m = board.size();
        int n = board.get(0).length();

        Pair ans = solve(m - 1, n - 1, board);

        int[] res = new int[2];
        res[0] = ans.score;
        res[1] = ans.Path;
        return res;

    }

    public static boolean isValid(int i, int j, int m, int n, char ch) {

        if (i >= 0 && j >= 0 && i < m && j < n && ch != 'X') {
            return true;
        }
        return false;

    }
}

class Pair {

    int score;
    int Path;

    public Pair(int score, int path) {
        this.score = score;
        Path = path;
    }

}
