package interview.twoheaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfAStream {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianOfAStream() {
        this.maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        this.minHeap = new PriorityQueue<>(Comparator.naturalOrder());
    }

    public void insertNum(int num) {
        if (this.maxHeap.isEmpty() || this.maxHeap.peek() >= num) {
            this.maxHeap.offer(num);
        } else {
            this.minHeap.offer(num);
        }
        if (this.maxHeap.size() > this.minHeap.size() + 1) {
            this.minHeap.offer(this.maxHeap.remove());
        } else if (maxHeap.size() < this.minHeap.size()) {
            this.maxHeap.offer(this.minHeap.remove());
        }
    }

    public double findMedian() {
        boolean isEven =
                (this.minHeap.size() + this.maxHeap.size()) % 2 == 0;
        Integer maxNum = this.maxHeap.peek();
        return isEven ? ((this.minHeap.peek() + maxNum)) / 2d : maxNum;
    }

    public static void main(String[] args) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(2);
        medianOfAStream.insertNum(10);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}
