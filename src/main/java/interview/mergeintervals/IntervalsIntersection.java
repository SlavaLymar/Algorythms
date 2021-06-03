package interview.mergeintervals;

import java.util.ArrayList;
import java.util.List;

public class IntervalsIntersection {

    // Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
    // Output: [2, 3], [5, 6], [7, 7]
    //
    // |_|_|_|_|_|_|_|_|_|_|_|
    //   1       5       9
    //   |_|_|   |_| |_|_|
    //     |_|   |_|_|
    //
    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> intervalsIntersection = new ArrayList<>();
        int i1 = 0, i2 = 0, i3 = 0;
        boolean exit1 = false;
        boolean exit2 = false;
        while ((!exit1 || !exit2) && i1 < arr1.length && i2 < arr2.length) {
            if (arr1[i1].end >= arr2[i2].start) {
                int start = Math.max(arr1[i1].start, arr2[i2].start);
                int end = Math.min(arr1[i1].end, arr2[i2].end);
                if (!intervalsIntersection.isEmpty()) {
                    if (intervalsIntersection.get(i3).start >= end) {
                        start = Math.max(start, intervalsIntersection.get(i3).start);
                        end = Math.min(end, intervalsIntersection.get(i3).end);
                    } else {
                        i3++;
                    }
                }
                intervalsIntersection.add(new Interval(start, end));
            }
            if (i1 + 1 < arr1.length) {
                i1++;
            } else {
                exit1 = true;
            }
            if (i2 + 1 < arr2.length) {
                i2++;
            } else {
                exit2 = true;
            }
        }
        return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);
    }

    public static void main(String[] args) {
        Interval[] input1 = new Interval[]{new Interval(1, 3), new Interval(5, 6), new Interval(7, 9)};
        Interval[] input2 = new Interval[]{new Interval(2, 3), new Interval(5, 7)};
        Interval[] result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input1 = new Interval[]{new Interval(1, 3), new Interval(5, 7), new Interval(9, 12)};
        input2 = new Interval[]{new Interval(5, 10)};
        result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
    }

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    ;
}
