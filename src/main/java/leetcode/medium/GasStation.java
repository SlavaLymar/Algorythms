package leetcode.medium;

public class GasStation {

    //              g
    // gas = [1,2,3,4,5], cost = [3,4,5,1,2]
    //                                  c
    // g   c
    // 4 - 1 +5
    // 8 - 2 +1
    // 7 - 3 +2
    // 6 - 4 +3
    // 5 - 5 +4
    //
    // t: O (N)
    // space: O (1)
    //
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total_tank = 0;
        int curr_tank = 0;
        int starting_station = 0;
        for (int i = 0; i < n; ++i) {
            total_tank += gas[i] - cost[i];
            curr_tank += gas[i] - cost[i];
            // If one couldn't get here,
            if (curr_tank < 0) {
                // Pick up the next station as the starting one.
                starting_station = i + 1;
                // Start with an empty tank.
                curr_tank = 0;
            }
        }
        return total_tank >= 0 ? starting_station : -1;
    }

    public static void main(String[] args) {
        System.out.println(new GasStation().canCompleteCircuit(
                new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}
        ));
        System.out.println(new GasStation().canCompleteCircuit(
                new int[]{2, 3, 4}, new int[]{3, 4, 3}
        ));
    }
}
