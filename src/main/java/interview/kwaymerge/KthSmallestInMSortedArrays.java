package interview.kwaymerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestInMSortedArrays {

    static class ArrSequence {
        Integer[] arr;
        int index;

        ArrSequence(Integer[] arr, int index) {
            this.arr = arr;
            this.index = index;
        }
    }
    //            v             v             v
    // Input: L1=[2, 6, 8], L2=[3, 6, 7], L3=[1, 3, 4], K=5
    // Output: 4
    // [1,2,3], count = 0
    //
    // t: O (k * Log M)
    // space: O (M)
    //
    public static int findKthSmallest(List<Integer[]> lists, int k) {
        Queue<ArrSequence> queue = new PriorityQueue<>((a1, a2) -> a1.arr[a1.index] - a2.arr[a2.index]);
        for (Integer[] arr: lists) {
            queue.add(new ArrSequence(arr, 0));
        }
        int count = 0;
        while (!queue.isEmpty()) {
            ArrSequence obj = queue.poll();
            count++;
            if (count == k) {
                return obj.arr[obj.index];
            }
            if (obj.index + 1 < obj.arr.length) {
                obj.index++;
                queue.add(obj);
            }
        }
        throw new RuntimeException("K smallest number does not exist");
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 2, 6, 8 };
        Integer[] l2 = new Integer[] { 3, 6, 7 };
        Integer[] l3 = new Integer[] { 1, 3, 4 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int result = KthSmallestInMSortedArrays.findKthSmallest(lists, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}
