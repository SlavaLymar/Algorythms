package interview.slidingwindow;

public class MaxSumSubArrayOfSizeK {

    public static void main(String[] args) {
        int result = findMaxSumSubArray(3, new int[]{ 2, 1, 5, 1, 3, 2 });
        System.out.println("Subarray with maximum sum is " + result);
        int result1 = findMaxSumSubArray(2, new int[]{ 2, 3, 4, 1, 5 });
        System.out.println("Subarray with maximum sum is " + result1);
    }

    public static int findMaxSumSubArray(int k, int[] arr) {
        int windowSum = 0, maxSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            if (windowEnd >= k - 1) {
               maxSum = Math.max(windowSum, maxSum);
               windowSum -= arr[windowStart++];
            }
        }
        return maxSum;
    }
}
