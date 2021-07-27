package interview.hackerrank;

import java.util.Arrays;
import java.util.List;

public class MinXWhileSum {

    public static int minX(List<Integer> arr) {
        int result = 0;
        int sum = 0;
        for (int x : arr) {
            sum += x;
            if (result > sum) {
                result = sum;
            }
        }
        return Math.abs(result) + 1;
    }

    public static void main(String[] args) {
        System.out.println(minX(Arrays.asList(new Integer[]{-5, 4, -2, 3, 1, -1, -6, -1, 0, 5})));
    }

}