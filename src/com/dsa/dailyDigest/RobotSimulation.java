package com.dsa.dailyDigest;

import java.util.HashSet;
import java.util.Set;

public class RobotSimulation {
    public static void main(String[] args) {

        int[] commands = { 4, -1, 3 };
        int[][] obstacles = {};

        System.out.println(robotSim(commands, obstacles));

    }

    public static int robotSim(int[] commands, int[][] obstacles) {

        Set<String> set = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            String key = String.valueOf(obstacles[i][0] + "|" + obstacles[i][1]);
            set.add(key);
        }
        int max = 0;
        int x = 0;
        int y = 0;
        CoOrdinates dir = new CoOrdinates(0, 1); // pointing to north
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -2) {
                dir = new CoOrdinates(-dir.y, dir.x); // turn left
            } else if (commands[i] == -1) {
                dir = new CoOrdinates(dir.y, -dir.x); // turn right
            } else {

                for (int j = 0; j < commands[i]; j++) {

                    int new_x = x + dir.x;
                    int new_y = y + dir.y;

                    String nextKey = String.valueOf(new_x) + "|" + String.valueOf(new_y);
                    if (set.contains(nextKey)) {
                        break;
                    }
                    x = new_x;
                    y = new_y;
                    max = Math.max(max, x * x + y * y);

                }
            }

        }
        return max;

    }

}

class CoOrdinates {

    int x;
    int y;

    CoOrdinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
