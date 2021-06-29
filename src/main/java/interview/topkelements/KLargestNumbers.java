package interview.topkelements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KLargestNumbers {

    // [3, 1, 5, 12, 2, 11], K = 3
    //
    // 1. [1, 3, 5]
    // 2. [3, 5, 12] -> [5, 11, 12]
    //
    // t: O ( K * Log K + (N - K) * Log K) => K * Log K + N * Log K - K * Log K => N * Log K
    // space: O (K)
    public static List<Integer> findKLargestNumbers(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Integer::compare);
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (queue.peek() < nums[i]) {
                queue.remove();
                queue.add(nums[i]);
            }
        }
        return new ArrayList<>(queue);
    }

    public static void main(String[] args) {
        List<Integer> result = KLargestNumbers.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
        System.out.println("Here are the top K numbers: " + result);

        result = KLargestNumbers.findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Here are the top K numbers: " + result);
    }
}
