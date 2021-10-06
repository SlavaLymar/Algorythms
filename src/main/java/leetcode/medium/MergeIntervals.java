package leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;


public class MergeIntervals {

    //
    // [[1,3],[2,6],[8,10],[15,18]]
    //
    // t: O (N * Log N + N)
    // space: O (N)
    //
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {

        System.out.println(Arrays.deepToString(merge(new int[][]{
                {2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}
        })));
        System.out.println(Arrays.deepToString(merge(new int[][]{
                {1, 4}, {0, 2}, {3, 5}
        })));
        System.out.println(Arrays.deepToString(merge(new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        })));
        System.out.println(Arrays.deepToString(merge(new int[][]{
                {1, 4}, {4, 5}
        })));
        System.out.println(Arrays.deepToString(merge(new int[][]{
                {1, 4}, {5, 6}
        })));
        System.out.println(Arrays.deepToString(merge(new int[][]{
                {1, 3}
        })));
        System.out.println(Arrays.deepToString(merge(new int[][]{
                {1, 4}, {0, 4}
        })));
    }
}
