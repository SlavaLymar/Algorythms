package leetcode.medium;

import java.util.Arrays;

public class KthLargestElementInArray {

    //
    // [3,2,1,5,6,4], k = 2
    //
    // [5,6]
    //
    // t: O (N * Log K)
    // space: O (K)
    //
    // public int findKthLargest(int[] nums, int k) {
    //     if (k < 1) return -1;
    //     Queue<Integer> queue = new PriorityQueue<>((a,b) -> a - b);
    //     for (int num : nums) {
    //         queue.offer(num);
    //         if (queue.size() > k) {
    //             queue.remove();
    //         }
    //     }
    //     return queue.peek();
    // }

    //
    // [3,2,1,5,6,4], k = 2
    //
    // t: O (N * Log N)
    // space: O (1)
    //
    public int findKthLargest(int[] nums, int k) {
        if (k < 1) return -1;
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        System.out.println(new KthLargestElementInArray().findKthLargest(
                new int[]{3,2,3,1,2,4,5,5,6}, 4
        ));
    }
}
