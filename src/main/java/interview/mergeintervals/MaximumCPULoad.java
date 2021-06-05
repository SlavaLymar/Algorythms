package interview.mergeintervals;

import java.util.*;

public class MaximumCPULoad {

    // Jobs: [[1,4,3], [2,5,4], [7,9,6]]
    // Output: 7
    //    v
    // [[1,4,3], [2,5,4], [7,9,6]]   [[1,4,3]]
    //              v
    // [[1,4,3], [2,5,4], [7,9,6]]   [[1,4,3], [2,5,4]]
    //                       v
    // [[1,4,3], [2,5,4], [7,9,6]]   [[7,9,6]]
    //
    // |_|_|_|_|_|_|_|_|_|_|
    //   1       5       9
    //   |_|_|_|      |_|_|
    //     |_|_|_|
    // N * Log N + N + N = N * Log N
    public static int findMaxCPULoad(List<Job> jobs) {
        jobs.sort(Comparator.comparingInt(o -> o.start)); // N * Log N
        int curLoadCPU = 0, maxLoadCPU = curLoadCPU;
        Queue<Job> queue =
                new PriorityQueue<>(jobs.size(), Comparator.comparingInt(o -> o.end));
        for (Job job : jobs) { // N
            while (queue.size() > 0 && job.start >= queue.peek().end) { // N
                curLoadCPU -= queue.remove().cpuLoad;
            }
            queue.offer(job);
            curLoadCPU += job.cpuLoad;
            maxLoadCPU = Math.max(maxLoadCPU, curLoadCPU);
        }
        return maxLoadCPU;
    }

    public static void main(String[] args) {
        List<Job> input = new ArrayList<>(
                Arrays.asList(
                        new Job(1, 4, 3),
                        new Job(2, 5, 4),
                        new Job(7, 9, 6))
        );
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<>(
                Arrays.asList(
                        new Job(6, 7, 10),
                        new Job(2, 4, 11),
                        new Job(8, 12, 15))
        );
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<>(
                Arrays.asList(
                        new Job(1, 4, 2),
                        new Job(2, 4, 1),
                        new Job(3, 6, 5))
        );
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
    }


    static class Job {
        int start;
        int end;
        int cpuLoad;

        public Job(int start, int end, int cpuLoad) {
            this.start = start;
            this.end = end;
            this.cpuLoad = cpuLoad;
        }
    }
}
