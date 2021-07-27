package interview.topologicalsort;

import java.util.*;

public class TaskScheduling {

    //
    // Tasks=3, Prerequisites=[0, 1], [1, 2]
    //
    //         0 -> 1 -> 2
    //
    // 1. init (for tasks):
    // childCount: {{0:0}, {1:0}, {2:0}} => {task, count}
    // graph: {{0:[]}, {1:[]}, {2:[]}} => {edge: [list of children]}
    //
    // 2. build graph (for prerequisites):
    // childCount: {{0:0}, {1:1}, {2:1}}
    // graph: {{0:[1]}, {1:[2]}, {2:[]}}
    //
    // 3. find source (for by childCount):
    // if childCount[i] == 0 => source
    // queue: [0]
    //
    // 4. fill orderList (while !queue.isEmpty)
    // queue: []
    // childCount: {{0:0}, {1:0}, {2:0}}
    // graph: {{0:[1]}, {1:[2]}, {2:[]}}
    // orderList: [0, 1, 2]
    //
    // 5. return orderList.size() == tasks
    //
    // t: O (T + P)
    // space: O (T + P)
    //
    public static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {
        if (tasks <= 0) return false;
        if (prerequisites.length + 1 < tasks) return false;

        // 1.
        Map<Integer, Integer> childCount = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < tasks; i++) {
            childCount.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        // 2.
        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0], child = prerequisites[i][1];
            childCount.put(child, childCount.get(child) + 1);
            graph.get(parent).add(child);
        }

        // 3.
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry: childCount.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }

        // 4.
        List<Integer> orderList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int source = queue.poll();
            orderList.add(source);
            for (Integer child : graph.get(source)) {
                childCount.put(child, childCount.get(child) - 1);
                if (childCount.get(child) == 0) {
                    queue.offer(child);
                }
            }
        }

        // 5.
        return orderList.size() == tasks;
    }

    public static void main(String[] args) {

        boolean result = TaskScheduling.isSchedulingPossible(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println("Tasks execution possible: " + result);

        result = TaskScheduling.isSchedulingPossible(3,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
        System.out.println("Tasks execution possible: " + result);

        result = TaskScheduling.isSchedulingPossible(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 },
                new int[] { 0, 4 }, new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println("Tasks execution possible: " + result);
    }
}
