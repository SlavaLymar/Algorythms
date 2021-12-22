package leetcode.hard;

import java.util.Arrays;

public class LargestRectangleInHistogram {

    //
    //
    //  i
    //  0, 9         square = 6, min = 1
    //
    //
    //
    //
    //
    //
    public int largestRectangleArea(int[] heights) {
        if (heights == null) return -1;
        int length = heights.length;
        if (length == 1) return heights[0];
        if (length == 0) return 0;
        return helper(heights);
    }

    public int helper(int[] arr) {
        int length = arr.length;
        if (length == 1) return arr[0];
        if (length == 0) return 0;
        int square = length, minIdx = this.findMinValue(arr);
        square = square * arr[minIdx];
        int[] left = Arrays.copyOfRange(arr, 0, minIdx);
        int[] right = Arrays.copyOfRange(arr, minIdx + 1, length);
        return Math.max(square, Math.max(helper(left), helper(right)));
    }

    private int findMinValue(int[] arr) {
        if (arr.length == 1) return 0;
        int minIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[minIdx]) {
                minIdx = i;
            }
        }
        return minIdx;
    }

    public static void main(String[] args) {
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(new int[]{0,9}));
    }
}
