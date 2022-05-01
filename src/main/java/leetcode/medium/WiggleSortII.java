package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class WiggleSortII {

    //
    //
    // 1, 3, 2, 3, 2, 1
    //
    //       l
    // 1, 3, 2, 2, 3, 1
    //                r
    // tmp = 1
    // i0 < i1 > i2 < i3
    //
    // t: O (N)
    // space: O (1)
    //
    public void wiggleSort(int[] nums) {
        if (nums == null && nums.length == 1) return;

        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int n : nums) {
            maxheap.offer(n);
        }
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = maxheap.poll();
        }
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = maxheap.poll();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 3, 1};
        new WiggleSortII().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{ 1,5,1,1,6,4 };
        new WiggleSortII().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{ 2,1 };
        new WiggleSortII().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{5, 5, 5, 4, 4, 4, 4};
        new WiggleSortII().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}