package leetcode.easy;

import java.util.Arrays;

public class MoveZeroes {

    //    n
    // [0,1,0,3,12]
    //  z
    //
    // t: O (N)
    // space: O (1)
    //
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int zero = 0;
        int nonZero = 0;
        while (zero < nums.length && nonZero < nums.length) {
            while (zero < nums.length && nums[zero] != 0) {
                zero++;
            }
            while (nonZero < nums.length && nums[nonZero] == 0) {
                nonZero++;
            }
            if (zero < nums.length && nonZero < nums.length && zero < nonZero) {
                swap(nums, zero, nonZero);
            } else {
                nonZero++;
            }
        }
    }

    private void swap(int[] nums, int z, int n) {
        int tmp = nums[z];
        nums[z] = nums[n];
        nums[n] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,3,12};
        new MoveZeroes().moveZeroes(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = new int[]{1,0};
        new MoveZeroes().moveZeroes(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = new int[]{1,0,1};
        new MoveZeroes().moveZeroes(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
