package interview.topkelements;

import java.util.*;

public class TaskScheduler {

    //
    // [a, a, a, b, c, c], K=2, Output: 7
    // [ [a,1] ] | [  ] | n = K + 1
    // a -> c -> b -> a -> c -> 1 -> a
    //
    // t: O (N + N * Log N + N) => 2N + N * Log N => N (2 + Log N) => N * Log N
    // space: O (N)
    //
    public static int scheduleTasks(char[] tasks, int k) {
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char ch : tasks) {
            charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) + 1);
        }
        Queue<Map.Entry<Character, Integer>> queue
                = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        queue.addAll(charFrequency.entrySet());

        int taskCount = 0;
        while (!queue.isEmpty()) {
            List<Map.Entry<Character, Integer>> buffer = new ArrayList<>();
            int n = k + 1;
            for (; n > 0 && !queue.isEmpty(); n--) {
                Map.Entry<Character, Integer> entry = queue.poll();
                if (entry.getValue() > 0) {
                    taskCount++;
                    if (entry.getValue() - 1 > 0) {
                        entry.setValue(entry.getValue() - 1);
                        buffer.add(entry);
                    }
                }
            }
            if (n > 0 && !buffer.isEmpty()) {
                taskCount += n;
            }
            queue.addAll(buffer);
        }
        return taskCount;
    }

    public static void main(String[] args) {
        char[] tasks = new char[] { 'a', 'a', 'a', 'b', 'c', 'c' };
        System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 2));

        tasks = new char[] { 'a', 'b', 'a' };
        System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 3));
    }



}
