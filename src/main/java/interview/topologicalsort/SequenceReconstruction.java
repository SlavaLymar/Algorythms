package interview.topologicalsort;

import java.util.*;

public class SequenceReconstruction {

    //
    // Input: originalSeq: [1, 2, 3, 4], seqs: [[1, 2], [2, 3], [2, 4]]
    // Output: false
    //
    // 1. init (for originalSeq):
    // numCount: {{1:0}, {2:0}, {3:0}, {4:0}}
    // graph: {{1:[]}, {2:[]}, {3:[]}, {4:[]}}
    //
    // 2. build graph (for seqs):
    // numCount: {{1:0}, {2:1}, {3:1}, {4:1}}
    // graph: {{1:[2]}, {2:[3,4]}, {3:[]}, {4:[]}}
    //
    // 3. find sources (for numCount):
    // sources: [1]
    //
    // 4. fill sortedOrder (while !sources.isEmpty):
    //      if sources > 1 => false
    // sortedOrder: []
    // sources: [1]
    // numCount: {{1:0}, {2:1}, {3:1}, {4:1}}
    // graph: {{1:[2]}, {2:[3,4]}, {3:[]}, {4:[]}}
    //
    // t: O (N * K)
    // space: O (N)
    //
    public static boolean canConstruct(int[] originalSeq, int[][] sequences) {
        if (originalSeq.length > 0 && sequences.length == 0) {
            return false;
        }

        // 1.
        Map<Integer, Integer> numCount = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] sequence : sequences) {
            for (int i = 0; i < sequence.length; i++) {
                numCount.put(sequence[i], 0);
                graph.put(sequence[i], new ArrayList<>());
            }
        }

        // 2.
        for (int[] sequence : sequences) {
            for (int i = 0; i < sequence.length - 1; i++) {
                int parent = sequence[i], child = sequence[i + 1];
                numCount.put(child, numCount.get(child) + 1);
                graph.get(parent).add(child);
            }
        }

        // 3.
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : numCount.entrySet()) {
            if (entry.getValue() == 0) {
                sources.offer(entry.getKey());
            }
        }

        // 4.
        List<Integer> sortedOrder = new ArrayList<>();
        int index = 0;
        while (!sources.isEmpty()) {
            if (sources.size() > 1) return false;
            Integer source = sources.poll();
            if (originalSeq[index++] != source) return false;
            sortedOrder.add(source);
            List<Integer> children = graph.get(source);
            for (Integer child : children) {
                numCount.put(child, numCount.get(child) - 1);
                if (numCount.get(child) == 0) {
                    sources.offer(child);
                }
            }
        }

        return sortedOrder.size() == originalSeq.length;
    }

    public static void main(String[] args) {
        boolean result = SequenceReconstruction.canConstruct(new int[]{1, 2, 3, 4},
                new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}});
        System.out.println("Can we uniquely construct the sequence: " + result);

        result = SequenceReconstruction.canConstruct(new int[]{1, 2, 3, 4},
                new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{2, 4}});
        System.out.println("Can we uniquely construct the sequence: " + result);

        result = SequenceReconstruction.canConstruct(new int[]{3, 1, 4, 2, 5},
                new int[][]{new int[]{3, 1, 5}, new int[]{1, 4, 2, 5}});
        System.out.println("Can we uniquely construct the sequence: " + result);
    }
}
