package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleTwo {

    public static void main(String[] args) {

        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 } };
        System.out.println(Arrays.toString(canFinish(numCourses, prerequisites)));

    }

    public static int[] canFinish(int numCourses, int[][] prerequisites) {

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
        List<Integer> sequence = new ArrayList<>();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            completeCourse++;
            sequence.add(current);

            for (Integer neighbours : map.get(current)) {
                inDegree[neighbours]--;

                if (inDegree[neighbours] == 0) {
                    queue.add(neighbours);
                }
            }
        }

        if (completeCourse != numCourses) {
            return new int[0];
        }
        int[] res = sequence.stream().mapToInt(Integer::intValue).toArray();

        return res;

    }

}
