package interview.topkelements;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestNumberInStream {

    private Queue<Integer> minHeap = new PriorityQueue<>(Integer::compare);
    private int k;

    public KthLargestNumberInStream(int[] nums, int k) {
        this.k = k;
        for (int num : nums) {
            this.add(num);
        }
    }

    //
    // [3, 1, 5, 12, 2, 11], K = 4
    // [3, 5, 11, 12]
    // add(6) should return '5'.
    // [5, 6, 11, 12] => 5
    //
    // t: O (Log K)
    // space: O (K)
    //
    public int add(int num) {
        this.minHeap.add(num);                 // O (Log K)
        if (this.minHeap.size() > this.k) {
            this.minHeap.poll();
        }
        return this.minHeap.peek();
    }

    public static void main(String[] args) {
        int[] input = new int[] { 3, 1, 5, 12, 2, 11 };
        KthLargestNumberInStream kthLargestNumber = new KthLargestNumberInStream(input, 4);
        System.out.println("4th largest number is: " + kthLargestNumber.add(6));
        System.out.println("4th largest number is: " + kthLargestNumber.add(13));
        System.out.println("4th largest number is: " + kthLargestNumber.add(4));
    }
}
