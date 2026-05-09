package com.dsa.dailyDigest;

import java.util.List;

public class Robot {

    int width;
    int height;
    List<int[]> pos;
    int index;
    boolean isMoved = false;

    public Robot(int width, int height) {

        this.width = width;
        this.height = height;
        this.index = 0;
        this.pos = new java.util.ArrayList<>();

        // Bottom row (left to right) - East (0)
        for (int x = 0; x < width; x++) {
            pos.add(new int[] { x, 0, 0 });
        }

        // Right column (bottom to top) - North (1)
        for (int y = 1; y < height; y++) {
            pos.add(new int[] { width - 1, y, 1 });
        }

        // Top row (right to left) - West (2)
        for (int x = width - 2; x >= 0; x--) {
            pos.add(new int[] { x, height - 1, 2 });
        }

        // Left column (top to bottom) - South (3)
        for (int y = height - 2; y > 0; y--) {
            pos.add(new int[] { 0, y, 3 });
        }

        // Handle corner case for (0,0) after movement
        pos.get(0)[2] = 3;
    }

    public void step(int num) {
        isMoved = true;
        index = (index + num) % pos.size();
    }

    public int[] getPos() {
        return new int[] { pos.get(index)[0], pos.get(index)[1] };
    }

    public String getDir() {
        if (!isMoved)
            return "East";

        int d = pos.get(index)[2];

        if (d == 0)
            return "East";
        else if (d == 1)
            return "North";
        else if (d == 2)
            return "West";
        return "South";
    }

    public static void main(String[] args) {

        Robot obj = new Robot(5, 2);
        obj.step(8);
        // int[] param_2 = obj.getPos();
        // String param_3 = obj.getDir();

    }

}
