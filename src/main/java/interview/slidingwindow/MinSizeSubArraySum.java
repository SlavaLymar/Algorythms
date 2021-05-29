package interview.slidingwindow;

public class MinSizeSubArraySum {

    public static void main(String[] args) {
        int result = findMinSubArray(7, new int[]{ 2, 1, 5, 2, 3, 2 });
        System.out.println("The smallest subarray with a sum greater than or equal to " + result);
        int result1 = findMinSubArray(7, new int[]{ 2, 1, 5, 2, 8 });
        System.out.println("The smallest subarray with a sum greater than or equal to " + result1);
        int result2 = findMinSubArray(8, new int[]{ 3, 4, 1, 1, 6 });
        System.out.println("The smallest subarray with a sum greater than or equal to " + result2);
    }

    // 7, { 2, 1, 5, 2, 3, 2 }
    public static int findMinSubArray(int S, int[] arr) {
        int windowSum = 0, elementCounts = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            while (windowSum >= S) {
                int windowCounts = windowEnd - windowStart + 1;
                elementCounts = elementCounts == 0 ? windowCounts : Math.min(windowCounts, elementCounts);
                windowSum -= arr[windowStart++];
            }
        }
        return elementCounts;
    }
}
