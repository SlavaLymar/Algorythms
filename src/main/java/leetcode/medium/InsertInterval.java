package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    //                       i
    // Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
    // Output: [[1,2],[3,10],[12,16]]
    //
    // mergedIntervals = []
    //
    //                       i
    // Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
    // Output: [[1,3]]
    //
    // mergedIntervals = []
    //
    // t: O (N)
    // space: O (N)
    //
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> mergedIntervals = new ArrayList<>();

        int i = 0;
        // skip (and add to output) all intervals that come before the 'newInterval'
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            mergedIntervals.add(intervals[i++]);
        }

        // merge all intervals that overlap with 'newInterval'
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        // insert the newInterval
        mergedIntervals.add(newInterval);

        // add all the remaining intervals to the output
        while (i < intervals.length) {
            mergedIntervals.add(intervals[i++]);
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(insert(new int[][]{
                {1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}
        }, new int[]{4, 8})));

        System.out.println(Arrays.deepToString(insert(new int[][]{
                {1, 3}, {6, 9}
        }, new int[]{2, 5})));
    }
}
