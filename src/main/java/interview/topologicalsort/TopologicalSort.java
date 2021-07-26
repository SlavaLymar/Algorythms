package interview.topologicalsort;

import java.util.*;

public class TopologicalSort {

    //
    // Vertices=4, Edges=[3, 2], [3, 0], [2, 0], [2, 1]
    //
    // 0. init topological sort list:
    // sortedOrder: []
    //
    // 1. init(for by verticles):
    // inDegree: {{0:0}, {1:0}, {2:0}, {3:0}} => {verticles: count childs}
    // graph: {{0:[]}, {1:[]}, {2:[]}, {3:[]}} => {verticles: childs}
    //
    // 2. build graph (for by edges):
    // inDegree: {{0:2}, {1:1}, {2:1}, {3:0}} => 3 is a source
    // graph: {{0:[]}, {1:[]}, {2:[0,1]}, {3:[2,0]}} => 0 and 1 are sinks
    //
    // 3. init all sources (for by inDegree):
    // sources: [3] - queue
    //
    // 4. fill sortedOrder (while !queue.isEmpty):
    // sources: []
    // inDegree: {{0:0}, {1:0}, {2:0}, {3:0}}
    // sortedOrder: [3, 2, 0, 1]
    //
    // t: O (V + E)
    // space: O (V + E)
    //
    public static List<Integer> sort(int vertices, int[][] edges) {
        // 0.
        List<Integer> sortedOrder = new ArrayList<>();
        if (vertices <= 0 || edges.length == 0 || edges.length + 1 < vertices) return sortedOrder;

        // 1.
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        // 2.
        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0], child = edges[i][1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }

        // 3.
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry: inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }

        // 4.
        while (!queue.isEmpty()) {
            int source = queue.poll();
            sortedOrder.add(source);
            for (Integer child : graph.get(source)) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    queue.offer(child);
                }
            }
        }

        if (sortedOrder.size() > vertices) return new ArrayList<>();

        return sortedOrder;
    }

    public static void main(String[] args) {
        List<Integer> result = TopologicalSort.sort(4,
                new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println(result);

        result = TopologicalSort.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
                new int[] { 2, 1 }, new int[] { 3, 1 } });
        System.out.println(result);

        result = TopologicalSort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
                new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
        System.out.println(result);
    }
}
