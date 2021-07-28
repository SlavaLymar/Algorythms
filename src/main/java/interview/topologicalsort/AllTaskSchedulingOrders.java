package interview.topologicalsort;

import java.util.*;

public class AllTaskSchedulingOrders {

    //
    // Tasks=4, Prerequisites=[3, 2], [3, 0], [2, 0], [2, 1]
    // 1) [3, 2, 0, 1]
    // 2) [3, 2, 1, 0]
    //
    // 1. init (for tasks)
    // taskCount: {{0:0}, {1:0}, {2:0}, {3:0}}
    // graph: {{0:[]]}, {1:[]]}, {2:[]}, {3:[]]}}
    //
    // 2. build graph (for prerequisites)
    // taskCount: {{0:2}, {1:1}, {2:1}, {3:0}}
    // graph: {{0:[]]}, {1:[]]}, {2:[0,1]}, {3:[2,0]]}}
    //
    // 3. check sources (for taskCount)
    // queue: [3]
    //
    // 4.
    //
    // t: O(T! * P)
    // space: O (P)
    //
    public static void printOrders(int tasks, int[][] prerequisites) {
        if (tasks <= 0) {
            return;
        }

        // 1.
        Map<Integer, Integer> taskCount = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < tasks; i++) {
            taskCount.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        // 2.
        for (int[] prerequisite : prerequisites) {
            int parent = prerequisite[0], child = prerequisite[1];
            taskCount.put(child, taskCount.get(child) + 1);
            graph.get(parent).add(child);
        }

        // 3.
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : taskCount.entrySet()) {
            if (entry.getValue() == 0) {
                sources.offer(entry.getKey());
            }
        }

        // 4.
        List<Integer> preOrder = new ArrayList<>();
        printAllTopologicalSorts(graph, taskCount, sources, preOrder);
    }

    private static void printAllTopologicalSorts(Map<Integer, List<Integer>> graph,
                                                 Map<Integer, Integer> taskCount,
                                                 Queue<Integer> sources,
                                                 List<Integer> preOrder) {
        if (!sources.isEmpty()) {
            for (Integer vertex : sources) {
                preOrder.add(vertex);
                Queue<Integer> sourcesForNextCall = cloneQueue(sources);
                // only remove the current source, all other sources should remain in the queue for the next call
                sourcesForNextCall.remove(vertex);
                List<Integer> children = graph.get(vertex); // get the node's children to decrement their in-degrees
                for (int child : children) {
                    taskCount.put(child, taskCount.get(child) - 1);
                    if (taskCount.get(child) == 0)
                        sourcesForNextCall.add(child); // save the new source for the next call
                }

                // recursive call to print other orderings from the remaining (and new) sources
                printAllTopologicalSorts(graph, taskCount, sourcesForNextCall, preOrder);

                // backtrack, remove the vertex from the sorted order and put all of its children back to consider
                // the next source instead of the current vertex
                preOrder.remove(vertex);
                for (int child : children)
                    taskCount.put(child, taskCount.get(child) + 1);
            }
        }

        // if preOrder doesn't contain all tasks, either we've a cyclic dependency between tasks, or
        // we have not processed all the tasks in this recursive call
        if (preOrder.size() == taskCount.size())
            System.out.println(preOrder);
    }

    // makes a deep copy of the queue
    private static Queue<Integer> cloneQueue(Queue<Integer> queue) {
        Queue<Integer> clone = new LinkedList<>();
        for (Integer num : queue)
            clone.add(num);
        return clone;
    }

    public static void main(String[] args) {
        AllTaskSchedulingOrders.printOrders(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println();

        AllTaskSchedulingOrders.printOrders(4,
                new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println();

        AllTaskSchedulingOrders.printOrders(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
                new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println();
    }
}
