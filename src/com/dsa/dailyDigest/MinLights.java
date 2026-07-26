package com.dsa.dailyDigest;

public class MinLights {

    public static void main(String[] args) {

        int[] lights = { 0, 0, 0, 2, 0 };
        System.out.println(minLights(lights));

    }

    public static int minLights(int[] lights) {

        int ans = 0;

        for (int i = 0; i < lights.length; i++) {
            if (lights[i] != 0) {
                int pos = Math.max(0, i - lights[i]);
                lights[pos] = Math.max(lights[pos], lights[i]);
            }

        }

        int coverage = 0;

        for (int i = 0; i < lights.length; i++) {

            if (lights[i] == 0 && coverage == 0) {
                ans++;

                if (i + 1 < lights.length && lights[i + 1] == 0) {
                    coverage = 3;
                }
            }
            coverage--;
            coverage = Math.max(coverage, lights[i]);

        }
        return ans;

    }

}
