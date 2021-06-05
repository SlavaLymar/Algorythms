package interview.mergeintervals;

import java.util.*;

public class EmployeeFreeTime {

    // Input: Employee Working Hours=[[[1,3], [9,12]], [[2,4]], [[6,8]]]
    // Output: [4,6], [8,9]
    //
    // |_|_|_|_|_|_|_|_|_|_|_|_|_|
    //   1       5       9
    //   |_|_|           |_|_|_|
    //     |_|_|   |_|_|
    //
    // [[[1,3], [9,12]], [[2,4]], [[6,8]]]
    //     v                           interval
    // [[[1,3], [2,4], [6,8], [9,12]] [1,3]
    //            v
    // [[[1,3], [2,4], [6,8], [9,12]] [1,4]
    //                   v
    // [[[1,3], [2,4], [6,8], [9,12]] != U => [interval.end, v.start] interval = [6, 8]
    //                           v
    // [[[1,3], [2,4], [6,8], [9,12]] != U => [interval.end, v.start] interval = [8, 9]
    //
    // N * M + Log N + N = N * M + Log N
    public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
        if (schedule == null || schedule.isEmpty()) {
            return Collections.emptyList();
        }

        Queue<Interval> allIntervals = new PriorityQueue<>(Comparator.comparingInt(o -> o.start));
        for (List<Interval> intervals : schedule) { // N * M
            for (Interval interval : intervals) {
                allIntervals.offer(interval); // Log N
            }
        }
        int start = Integer.MAX_VALUE, end = -1;
        List<Interval> result = new ArrayList<>();
        while (!allIntervals.isEmpty()) { // N
            Interval interval = allIntervals.poll();
            if (end == -1 || interval.start <= end) {
                start = Math.min(start, interval.start);
                end = Math.max(end, interval.end);
            } else {
                result.add(new Interval(end, interval.start));
                start = interval.start;
                end = interval.end;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        List<List<Interval>> input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
        List<Interval> result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(6, 8))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
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
