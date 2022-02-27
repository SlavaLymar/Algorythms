package leetcode.medium;

import java.util.*;

public class CourseSchedule {

    //
    // numCourses = 4, prerequisites = [[1,0],[2,1],[3,1]]
    //
    //             0
    //            /
    //           1
    //         /  \
    //        2    3
    //
    //
    // courses: [{0:0}, {1:1}, {2:1}, {3:1}]
    // graph: [{0:[1]}, {1:[2,3]}, {2:[]} {3:[]}]
    //
    // queue: [0]
    // current: 0
    //
    // t: O (N + P)
    // space: O (N + P)
    //
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> courses = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int c = 0; c < numCourses; c++) {
            courses.put(c, 0);
            graph.put(c, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int to = prerequisites[i][0], from = prerequisites[i][1];
            courses.put(to, courses.get(to) + 1);
            graph.getOrDefault(from, new ArrayList<>()).add(to);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : courses.entrySet()) {
            if (entry.getValue() == 0) queue.offer(entry.getKey());
        }

        int removedEdges = 0;
        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            if (graph.get(current) != null) {
                for (int child : graph.get(current)) {
                    courses.put(child, courses.get(child) - 1);
                    removedEdges++;
                    if (courses.get(child) == 0) {
                        queue.offer(child);
                    }
                }
            }

        }
        return removedEdges == prerequisites.length;
    }

    public static void main(String[] args) {
        System.out.println(new CourseSchedule().canFinish(4, new int[][]{{1,0},{2,1},{3,1}}));
        System.out.println(new CourseSchedule().canFinish(2, new int[][]{{1,0},{0,1}}));
    }
}
