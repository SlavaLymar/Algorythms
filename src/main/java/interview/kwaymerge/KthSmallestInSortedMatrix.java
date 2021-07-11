package interview.kwaymerge;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestInSortedMatrix {

    static class List {
        int[] arr;
        int index;

        List(int[] arr, int index) {
            this.arr = arr;
            this.index = index;
        }
    }

    static class ListComparator implements Comparator<List> {
        public int compare(List l1, List l2) {
            return l1.arr[l1.index] - l2.arr[l2.index];
        }
    }

    //     v            v             v
    // { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } }
    //
    // {2,3,5}, count = 0
    //
    // t: O (N + K*LogN)
    // space: O (N)
    //
    public static int findKthSmallest(int[][] matrix, int k) {
        Queue<List> queue = new PriorityQueue<>(new ListComparator());
        for (int[] arr : matrix) {
            queue.add(new List(arr, 0));
        }
        int count = 0;
        while (!queue.isEmpty()) {
            List list = queue.poll();
            count++;
            if (count == k) {
                return list.arr[list.index];
            }
            if (list.index + 1 < list.arr.length) {
                list.index++;
                queue.add(list);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
        int result = KthSmallestInSortedMatrix.findKthSmallest(matrix, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}
