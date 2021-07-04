package interview.topkelements;

import java.util.*;

public class MaximumDistinctElements {

    //
    // Input: [7, 3, 5, 8, 5, 3, 3], and K=2                 Input: [3, 5, 12, 11, 12], and K=3
    // [[7,1], [3,3], [5,2], [8,1]]                                 [[3,1], [5,1], [12,2], [11,1]]
    // [[5,2], [3,3]]                                               [[12,2]]
    // [5,1] => k = 1, [3,2] => k = 0                               [12,1] => k = 2 => count - k
    // Ответ: [5, 7, 8]                                             Ответ: [3, 5]
    //
    // t: O( N ∗ log N + K * log N)
    // space: O (N)
    public static int findMaximumDistinctElements(int[] nums, int k) {
        int distinctCount = 0;
        if (nums.length < k) {
            return distinctCount;
        }
        Map<Integer, Integer> numsFrequency = new HashMap<>();
        for (int num : nums) {
            numsFrequency.put(num, numsFrequency.getOrDefault(num, 0) + 1);
        }
        Queue<Map.Entry<Integer, Integer>> queue =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : numsFrequency.entrySet()) {
            if (entry.getValue() == 1) {
                distinctCount++;
            } else {
                queue.add(entry);
            }
        }
        while (k > 0 && !queue.isEmpty()) {
            Map.Entry<Integer, Integer> entry = queue.poll();
            k = k - entry.getValue() + 1;
            if (k > 0) {
                distinctCount++;
            }
        }
        if (k > 0) {
            distinctCount -= k;
        }
        return distinctCount;
    }

    public static void main(String[] args) {
        int result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);
    }
}
