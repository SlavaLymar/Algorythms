package leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoomsII {

    //
    // intervals = [[0,30],[5,10],[15,20]]
    //
    // 0             10              20              30
    // _______________________________________________
    //        ________
    //                        ________
    //
    // [[5,10], [15,20]]
    //
    // t: O (N log N)
    // space: O (N)
    //
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

        int maxRooms = 0;
        Queue<int[]> queue = new PriorityQueue<>((i1, i2) -> i1[1] - i2[1]);
        for (int[] interval : intervals) {

            while (!queue.isEmpty() && queue.peek()[1] <= interval[0]) {
                queue.remove();
            }

            queue.offer(interval);
            maxRooms = Math.max(maxRooms, queue.size());
        }
        return maxRooms;
    }

    public static void main(String[] args) {
        System.out.println(
                new MeetingRoomsII().minMeetingRooms(
                        new int[][]{{0,30},{5,10},{15,20}}
                )
        );
    }
}
