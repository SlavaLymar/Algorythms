package interview.topkelements;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestNumber {

    // [1, 5, 12, 2, 11, 5], K = 3
    //
    // [12, 5, 1] -> [5, 2, 1]
    //
    // t: O (K * Log K + (N - K) * Log K) => N * Log K
    // space: O (1)
    public static int findKthSmallestNumber(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (queue.peek() > nums[i]) {
                queue.remove();
                queue.add(nums[i]);
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
        System.out.println("Kth smallest number is: " + result);

        // since there are two 5s in the input array, our 3rd and 4th smallest numbers should be a '5'
        result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
        System.out.println("Kth smallest number is: " + result);

        result = KthSmallestNumber.findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Kth smallest number is: " + result);
    }
}
