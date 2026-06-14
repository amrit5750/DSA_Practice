package com.dsa.dailyDigest;

import java.util.Arrays;

public class AsteroidsDestroyed {
    public static void main(String[] args) {
        int mass = 5;
        int[] asteroids = { 4, 9, 23, 4 };
        System.out.println(asteroidsDestroyed(mass, asteroids));

    }

    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {

        Arrays.sort(asteroids);

        long currentMass = mass;

        for (int i = 0; i < asteroids.length; i++) {
            if (currentMass < asteroids[i]) {
                return false;
            }
            currentMass += asteroids[i];
        }

        return true;

    }

}
