package interview.topkelements;

import java.util.PriorityQueue;
import java.util.Queue;

public class SumOfElements {

    //
    // [1, 3, 12, 5, 15, 11], and K1=3, K2=6
    // l = K2 - K1 = 3
    // [11,12,15] => 23
    //
    // t: O (N * Log (k2 - k1) + (k2 - k1))
    // space: O (k2 - k1)
    //
    public static int findSumOfElements(int[] nums, int k1, int k2) {
        Queue<Integer> queue = new PriorityQueue<>(Integer::compare);
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k2 - k1) {
                queue.poll();
            }
        }
        int sum = 0;
        int tmp = 0;
        while (!queue.isEmpty()) {
            tmp = queue.poll();
            sum += tmp;
        }
        return sum - tmp;
    }

    public static void main(String[] args) {
        int result = SumOfElements.findSumOfElements(new int[] { 1, 3, 12, 5, 15, 11 }, 3, 6);
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);

        result = SumOfElements.findSumOfElements(new int[] { 3, 5, 8, 7 }, 1, 4);
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);
    }
}
