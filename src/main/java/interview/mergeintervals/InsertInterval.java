package interview.mergeintervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertInterval {


    // Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,10]
    // Output: [[1,3], [4,12]]
    //
    // |_|_|_|_|_|_|_|_|_|_|_|_|
    //   1       5       9
    // |_|_|
    //           |_|_|
    //                 |_|_|_|_|
    //         |_|_|_|_|_|_|
    //
    // 0 mergedIntervals = [[1,3]] newInterval = [4,10]
    //
    // 1 [[1,3]] [4,10]
    //
    // 2 [[1,3]] [4,12]
    //    [[1,3] [4,12]]
    //
    // ... [[1,3], [4,12], .... ]
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.isEmpty()) {
            return Collections.singletonList(newInterval);
        }
        List<Interval> mergedIntervals = new ArrayList<>();
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            mergedIntervals.add(intervals.get(i++));
        }
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i++).end, newInterval.end);
        }
        mergedIntervals.add(newInterval);
        while (i < intervals.size()) {
            mergedIntervals.add(intervals.get(i++));
        }
        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 7));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
