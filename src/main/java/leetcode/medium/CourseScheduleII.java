package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleII {

    //
    //
    // 1.frequency: [{0:0}, {1:1}, {2:1}, {3:2}}
    // 2.graph: [{0:[1,2]}, {1:[3]}, {2:[3]}, {3:[]}]
    // 3. queue: {0}       result: []
    //
    // t: O (N + P)
    // space: O (N + P)
    //
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null) {
            return new int[0];
        }

        Map<Integer, Integer> frequency = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            frequency.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int end = prerequisites[i][0], start = prerequisites[i][1];
            frequency.put(end, frequency.getOrDefault(end, 0) + 1);
            graph.get(start).add(end);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() == 0) queue.offer(entry.getKey());
        }

        int[] result = new int[numCourses];
        int idx = 0;
        while (!queue.isEmpty()) {
            Integer course = queue.poll();
            result[idx++] = course;
            for (Integer child : graph.get(course)) {
                frequency.put(child, frequency.get(child) - 1);
                if (frequency.get(child) == 0) {
                    queue.offer(child);
                }
            }
        }
        return idx != numCourses ? new int[0] : result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CourseScheduleII().findOrder(4,
                new int[][]{
                        {1, 0}, {2, 0}, {3, 1}, {3, 2}
                })));
    }
}
