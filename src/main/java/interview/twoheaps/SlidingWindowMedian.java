package interview.twoheaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMedian {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());

    public double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (maxHeap.peek() == null || maxHeap.peek() >= nums[i]) {
                maxHeap.add(nums[i]);
            } else {
                minHeap.add(nums[i]);
            }
            rebalanceHeaps();

            if (i - k + 1 >= 0) {
                if (k % 2 == 0) {
                    result[i - k + 1] = (maxHeap.peek() + minHeap.peek()) / 2d;
                } else {
                    result[i - k + 1] = maxHeap.peek();
                }
                int numToBeRemoved = nums[i - k + 1];
                if (numToBeRemoved <= maxHeap.peek()) {
                    maxHeap.remove(numToBeRemoved);
                } else {
                    minHeap.remove(numToBeRemoved);
                }
                rebalanceHeaps();
            }
        }
        return result;
    }

    private void rebalanceHeaps() {
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.remove());
        } else if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.remove());
        }
    }

    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result =
                slidingWindowMedian.findSlidingWindowMedian(
                        new int[]{1, 2, -1, 3, 5}, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new SlidingWindowMedian();
        result =
                slidingWindowMedian.findSlidingWindowMedian(
                        new int[]{1, 2, -1, 3, 5}, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }
}
