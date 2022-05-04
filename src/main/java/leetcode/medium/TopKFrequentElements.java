package leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {

    //
    // nums = [1,1,1,2,2,3], k = 2
    //
    // map: [{1:3}, {2:2}, {3:1}]
    // queue: [{1:3}, {2:2}]
    //
    // t: O (N * Log K)
    // space: O (N + K)
    //
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null) return new int[0];

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {                                               // N
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Map.Entry<Integer,Integer>> queue =                            // N * Log K
                new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] result = new int[k];                                            // K
        int i = result.length - 1;
        while (!queue.isEmpty()) {
            result[i--] = queue.poll().getKey();
        }
        return result;
    }
}
