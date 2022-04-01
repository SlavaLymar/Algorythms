package leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {

    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;

    //
    //    maxHeap          minHeap
    //       2
    //       1                3
    //       0
    //
    //
    public FindMedianFromDataStream() {
        this.maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        this.minHeap = new PriorityQueue<>(Comparator.naturalOrder());
    }

    public void addNum(int num) {
        if (this.maxHeap.isEmpty() || num < this.maxHeap.peek()) {
            this.maxHeap.offer(num);
        } else {
            this.minHeap.offer(num);
        }

        if (this.minHeap.size() > this.maxHeap.size()) {
            this.maxHeap.offer(this.minHeap.remove());
        } else if (this.maxHeap.size() > this.minHeap.size() + 1 ) {
            this.minHeap.offer(this.maxHeap.remove());
        }
    }

    public double findMedian() {
        boolean isEven =
                (this.minHeap.size() + this.maxHeap.size()) % 2 == 0;
        Integer maxNum = this.maxHeap.peek();
        return isEven ? ((this.minHeap.peek() + maxNum)) / 2d : maxNum;
    }

    public static void main(String[] args) {
        FindMedianFromDataStream instance = new FindMedianFromDataStream();
        instance.addNum(1);
        instance.addNum(2);
        System.out.println(instance.findMedian());
        instance.addNum(3);
        System.out.println(instance.findMedian());
    }
}
