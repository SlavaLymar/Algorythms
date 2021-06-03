package interview.mergeintervals;

import java.util.*;

public class MinimumMeetingRooms {

    // Meetings: [[4, 5], [2, 3], [2, 4], [3, 5]]
    // Output: 2
    //
    // [[2, 3], [2, 4], [3, 5], [4, 5]]
    //   ^ = 1 room == queue.size
    //             ^ if b.start < a.end => a U b => = 2 room == queue.size
    //                   ^ 2 room == queue.size
    //                            ^ 2 room == queue.size
    // |_|_|_|_|_|
    //   1       5
    //     |_|
    //     |_|_|
    //       |_|_|
    //         |_|
    public static int findMinimumMeetingRooms(List<Meeting> meetings) {
        if (meetings == null || meetings.isEmpty()) {
             return 0;
        }
        meetings.sort(Comparator.comparingInt(o -> o.start));
        Queue<Meeting> queue =
                new PriorityQueue<>(meetings.size(), Comparator.comparingInt(o -> o.end));
        int maxRoms = 0;
        for (Meeting meeting : meetings) {
            while (!queue.isEmpty() && meeting.start >= queue.peek().end) {
                queue.poll();
            }
            queue.offer(meeting);
            maxRoms = Math.max(maxRoms, queue.size());
        }
        return maxRoms;
    }

    public static void main(String[] args) {
        List<Meeting> input = new ArrayList<Meeting>() {
            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        int result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 5));
                add(new Meeting(7, 9));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(6, 7));
                add(new Meeting(2, 4));
                add(new Meeting(8, 12));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 3));
                add(new Meeting(3, 6));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);
    }

    static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
