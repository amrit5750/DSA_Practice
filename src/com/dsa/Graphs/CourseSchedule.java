package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule {

    public static void main(String[] args) {

        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 } };
        System.out.println(canFinish(numCourses, prerequisites));

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];
        for (int[] pre : prerequisites) {

            int course = pre[0];
            int preRequisite = pre[1];

            map.get(preRequisite).add(course);

            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);

            }

        }

        int completeCourse = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            completeCourse++;

            for (Integer neighbours : map.get(current)) {
                inDegree[neighbours]--;

                if (inDegree[neighbours] == 0) {
                    queue.add(neighbours);
                }
            }

        }

        return completeCourse == numCourses;

    }

}
