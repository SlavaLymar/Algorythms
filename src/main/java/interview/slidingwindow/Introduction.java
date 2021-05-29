package interview.slidingwindow;

import java.util.Arrays;

public class Introduction {

    public static void main(String[] args) {
        double[] result = findAverages(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
        System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
    }

    public static double[] findAverages(int K, int[] arr) {
        double[] result = new double[arr.length - K + 1];
        int sum = 0;
        int start = 0;
        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];
            if (arr.length - end <= K) {
                result[start] = sum / (double) K;
                sum -= arr[start];
                start++;
            }
        }
        return result;
    }
}
