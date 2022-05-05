package leetcode.medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementInASortedMatrix {

    static class Elements {
        int[] arr;
        int idx;
        Elements(int[] arr) {
            this.arr = arr;
            this.idx = 0;
        }
    }

    //                               v
    //                     v
    //            v
    // matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
    //
    // queue: [1,  10,  12]
    //         5   11   13
    //         9   13   15
    //
    // t: O (N * Log N + N ^ 2)
    // space: O (N)
    //
    //
    public int kthSmallest(int[][] matrix, int k) {

        Queue<Elements> queue =
                new PriorityQueue<>((e1, e2) -> e1.arr[e1.idx] - e2.arr[e2.idx]);
        for (int[] arr : matrix) {
            queue.offer(new Elements(arr));
        }

        while (!queue.isEmpty() && k > 1) {
            k--;
            Elements e = queue.poll();
            e.idx++;
            if (e.idx < e.arr.length) queue.offer(e);
        }

        Elements e = queue.poll();
        return e.arr[e.idx];
    }

    public static void main(String[] args) {
        System.out.println(
                new KthSmallestElementInASortedMatrix().kthSmallest(new int[][] {{1,5,9}, {10,11,13}, {12,13,15}}, 8)
        );
    }
}
