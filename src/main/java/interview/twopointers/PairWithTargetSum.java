package interview.twopointers;

import java.util.Arrays;

public class PairWithTargetSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(search(new int[]{1, 2, 3, 4, 6}, 6)));
    }

    public static int[] search(int[] arr, int targetSum) {
        if (arr == null || arr.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == targetSum) {
                return new int[]{left, right};
            } else if (sum > targetSum) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }
}
