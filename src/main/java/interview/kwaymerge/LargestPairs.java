package interview.kwaymerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class LargestPairs {

    //
    // L1=[9, 8, 2], L2=[6, 3, 1], K=3
    //    v           v
    // {{[9, 8, 2]}, [6, 3, 1]}
    // {[9,3], [8,6], [9,6]}
    //
    // t: O (M * N * Log K)
    // t: O (K)
    public static List<int[]> findKLargestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> queue = new PriorityQueue<>((p1, p2) -> (p1[0] + p1[1]) - (p2[0] + p2[1]) );
        for (int num1: nums1) {
            for (int num2: nums2) {
                if (queue.size() < k) {
                    queue.add(new int[]{ num1, num2 });
                } else {
                    int[] head = queue.poll();
                    if (num1 + num2 > head[0] + head[1]) {
                        queue.add(new int[]{ num1, num2 });
                    } else {
                        queue.add(head);
                        break;
                    }
                }
            }
        }
        return new ArrayList<>(queue);
    }

    public static void main(String[] args) {
        int[] l1 = new int[] { 9, 8, 2 };
        int[] l2 = new int[] { 6, 3, 1 };
        List<int[]> result = LargestPairs.findKLargestPairs(l1, l2, 3);
        System.out.print("Pairs with largest sum are: ");
        for (int[] pair : result)
            System.out.print("[" + pair[0] + ", " + pair[1] + "] ");
    }
}
