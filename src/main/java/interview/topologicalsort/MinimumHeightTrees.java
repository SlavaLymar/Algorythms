package interview.topologicalsort;

import java.util.*;

public class MinimumHeightTrees {

    //
    // Input: vertices: 4, Edges: [[0, 1], [0, 2], [2, 3]]
    // Output:[0, 2]
    //
    // 1. init (for vertices):
    // numCount: {{0:0}, {1:0}, {2:0}, {3:0}}
    // graph: {{0:[]]}, {1:[]}, {2:[]}, {3:[]}}
    //
    // 2. build graph (for edges):
    // numCount: {{0:2}, {1:1}, {2:2}, {3:1}}
    // graph: {{0:[1, 2]]}, {1:[0]}, {2:[0,3]}, {3:[2]}}
    //
    // 3. find leaves (if numCount == 1):
    // leaves: [1,3]
    //
    // 4. count height from leaves:
    //
    // numCount: {{0:2}, {1:1}, {2:2}, {3:1}}
    //
    // 0[1,2] > 1[0]
    //        > 2[0,3] > 3[2]        => 3
    //
    // 1[0] > 0[1,2] > 2[0,3] > 3[2] => 4
    //
    // 2[0,3] > 0[1,2] > 1[0]        => 3
    //        > 3[2]
    //
    // 3[2] > 2[0,3] > 0[1,2] > 1[0] => 4
    //
    // 4.   result.get(min) => [0,2]
    //
    // t: O (V + E)
    // space: O (V)
    //
    public static List<Integer> findTrees(int nodes, int[][] edges) {
        List<Integer> minHeightTrees = new ArrayList<>();
        if (nodes == 0 || edges.length == 0) {
            return minHeightTrees;
        }

        // 1.
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> numCount = new HashMap<>();
        Map<Integer, List<Integer>> result = new HashMap<>();
        for (int i = 0; i < nodes; i ++) {
            graph.put(i, new ArrayList<>());
            numCount.put(i, 0);
            result.put(i, new ArrayList<>());
        }

        // 2.
        for (int[] edge : edges) {
            int e1 = edge[0], e2 = edge[1];
            graph.get(e1).add(e2);
            graph.get(e2).add(e1);
            numCount.put(e1, numCount.get(e1) + 1);
            numCount.put(e2, numCount.get(e2) + 1);
        }

        // 3. Find all leaves i.e., all nodes with only 1 in-degree
        Queue<Integer> leaves = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : numCount.entrySet()) {
            if (entry.getValue() == 1)
                leaves.add(entry.getKey());
        }

        // 4. Remove leaves level by level and subtract each leave's children's in-degrees.
        // Repeat this until we are left with 1 or 2 nodes, which will be our answer.
        // Any node that has already been a leaf cannot be the root of a minimum height tree, because
        // its adjacent non-leaf node will always be a better candidate.
        int totalNodes = nodes;
        while (totalNodes > 2) {
            int leavesSize = leaves.size();
            totalNodes -= leavesSize;
            for (int i = 0; i < leavesSize; i++) {
                int vertex = leaves.poll();
                List<Integer> children = graph.get(vertex);
                for (int child : children) {
                    numCount.put(child, numCount.get(child) - 1);
                    if (numCount.get(child) == 1) // if the child has become a leaf
                        leaves.add(child);
                }
            }
        }

        minHeightTrees.addAll(leaves);

        return minHeightTrees;
    }

    public static void main(String[] args) {
        List<Integer> result = MinimumHeightTrees.findTrees(5,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 1, 3 }, new int[] { 2, 4 } });
        System.out.println("Roots of MHTs: " + result);

        result = MinimumHeightTrees.findTrees(4,
                new int[][] { new int[] { 0, 1 }, new int[] { 0, 2 }, new int[] { 2, 3 } });
        System.out.println("Roots of MHTs: " + result);

        result = MinimumHeightTrees.findTrees(4,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 1, 3 } });
        System.out.println("Roots of MHTs: " + result);
    }
}
