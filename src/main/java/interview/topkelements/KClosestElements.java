package interview.topkelements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestElements {

    //
    // [2, 4, 5, 6, 9], K = 3, X = 6
    // answer: [4, 5, 6]
    //
    // [4, 5, 6, 9]
    // [4,2, 5,1, 6,0]
    //
    // t: O (Log N + 2K * Log K + K)
    // space: O (K)
    public static List<Integer> findClosestElements(int[] arr, int K, Integer X) {
        int index = binarySearch(arr, X); // O (Log N)
        int left = index - K + 1, right = index + K - 1;
        Queue<Entry> queue = new PriorityQueue<>((e1, e2) -> e2.value - e1.value);
        for (int i = left; i < arr.length && i <= right; i++) { // O (2K)
            queue.add(new Entry(arr[i], Math.abs(arr[i] - X))); // Log K
            if (queue.size() > K) {
                queue.poll();
            }
        }
        List<Integer> result = new ArrayList<>(K);
        while (!queue.isEmpty()) {        // O (K)
            result.add(queue.poll().key);
        }
        return result;
    }

    //  s
    // [2, 4, 5, 6, 9]
    //        m     e
    private static int binarySearch(int[] arr, Integer X) {
        int start = 0, end = arr.length - 1, mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == X) {
                return mid;
            } else if (arr[mid] < X) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        List<Integer> result = KClosestElements.findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 10);
        System.out.println("'K' closest numbers to 'X' are: " + result);
    }

    static class Entry {
        int key;
        int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
