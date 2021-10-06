package leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class MergeIntervals {

    //                      i
    // Input: intervals = [[1,4],[4,5]]
    // Output: [[1,5]]
    // mergedIntervals: [], start = 1, end = 4
    //
    //                       i
    // Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    // Output: [[1,6],[8,10],[15,18]]
    // mergedIntervals: [], start = 1, end = 3
    //
    // t: O (N)
    // space: O (N)
    //
    public static int[][] merge(int[][] intervals) {
        List<int[]> mergedIntervals = new LinkedList<>();
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= end) {
                end = Math.max(interval[1], end);
            } else {
                mergedIntervals.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        mergedIntervals.add(new int[]{start, end});
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
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
