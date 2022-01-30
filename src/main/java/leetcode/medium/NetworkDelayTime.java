package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelayTime {

    //           u v w
    // times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
    //
    // {u: [v,w]} | graph: [{2: [[1,1], [3,1]]}, {3: [[4,1]]}]
    // [[distance,k]] | heap: [[2,4]]
    // seen: [t,t,t,f]
    //
    // t: O (E * logE) -> E - times.length
    // space: O (N + E)
    //
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] edge: times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((info1, info2) -> info1[0] - info2[0]);
        heap.offer(new int[]{0, k});

        Map<Integer, Integer> dist = new HashMap<>();

        while (!heap.isEmpty()) {
            int[] info = heap.poll();
            int d = info[0], node = info[1];
            if (dist.containsKey(node)) continue;
            dist.put(node, d);
            if (graph.containsKey(node))
                for (int[] edge: graph.get(node)) {
                    int nei = edge[0], d2 = edge[1];
                    if (!dist.containsKey(nei))
                        heap.offer(new int[]{d+d2, nei});
                }
        }

        if (dist.size() != n) return -1;
        int ans = 0;
        for (int cand: dist.values())
            ans = Math.max(ans, cand);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new NetworkDelayTime()
                .networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4, 2));
        System.out.println(new NetworkDelayTime()
                .networkDelayTime(new int[][]{{1,2,1},{2,1,2}}, 2, 2));
        System.out.println(new NetworkDelayTime()
                .networkDelayTime(new int[][]{{1,2,1}}, 2, 2));
    }
}
