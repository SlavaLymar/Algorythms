package interview.topkelements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SmallestRange {

    static class Arr {
        Integer[] arr;
        int index;

        Arr(Integer[] arr, int index) {
            this.arr = arr;
            this.index = index;
        }
    }

    //            v             v           v
    // Input: L1=[1, 5, 8], L2=[4, 12], L3=[7, 8, 10]
    // Output: [4, 7]
    //
    // [1,4,7] => 6
    // [4,5,7] => 3
    // [5,7,12] => 7
    // [7,8,12] => 5
    // [8,8,12] => 4
    //
    // t: O (M * Log M + M * N)
    // space: O (M)
    //
    public static int[] findSmallestRange(List<Integer[]> lists) {
        Queue<Arr> queue =
                new PriorityQueue<>((l1, l2) -> l1.arr[l1.index] - l2.arr[l2.index]);
        int currentMax = Integer.MIN_VALUE;
        for (Integer[] list : lists) {
            if (list != null) {
                queue.add(new Arr(list, 0));
                currentMax = Math.max(currentMax, list[0]);
            }
        }
        int[] result = new int[] { 0, Integer.MAX_VALUE };
        while (!queue.isEmpty() && queue.size() == lists.size()) {
            Arr arr = queue.poll();
            if (result[1] - result[0] > currentMax - arr.arr[arr.index]) {
                result[0] = arr.arr[arr.index];
                result[1] = currentMax;
            }
            if (arr.index + 1 < arr.arr.length) {
                arr.index++;
                queue.add(arr);
                currentMax = Math.max(currentMax, arr.arr[arr.index]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 1, 5, 8 };
        Integer[] l2 = new Integer[] { 4, 12 };
        Integer[] l3 = new Integer[] { 7, 8, 10 };
        List<Integer[]> lists = new ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int[] result = SmallestRange.findSmallestRange(lists);
        System.out.println("Smallest range is: [" + result[0] + ", " + result[1] + "]");

        l1 = new Integer[] { 1, 9 };
        l2 = new Integer[] { 4, 12 };
        l3 = new Integer[] { 7, 10, 16 };
        lists = new ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        result = SmallestRange.findSmallestRange(lists);
        System.out.println("Smallest range is: [" + result[0] + ", " + result[1] + "]");
    }
}
