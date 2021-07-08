package interview.topkelements;

import java.util.PriorityQueue;
import java.util.Queue;

public class ConnectRopes {

    // [1, 3, 11, 5, 2] 42
    //
    // [1, 2, 3, 5, 11] -> N * Log N
    // [3, 6, 11, 22]
    //
    // t: O (N * Log N)
    // space: O (N)
    //
    public static int minimumCostToConnectRopes(int[] ropeLengths) {
        Queue<Integer> queue = new PriorityQueue<>(Integer::compare);
        for (int num : ropeLengths) {
            queue.add(num);
        }
        int result = 0, tmp = 0;
        while (queue.size() > 1) {
            tmp = queue.poll() + queue.poll();
            result += tmp;
            queue.add(tmp);
        }
        return result;
    }

    public static void main(String[] args) {
        int result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
        System.out.println("Minimum cost to connect ropes: " + result);
    }

}
