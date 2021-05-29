package interview.slidingwindow;

public class ReplacingOnes {

    // 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1
    public static int findLength(int[] arr, int k) {
        int resultLength = 0, windowStart = 0, zeroCount = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if (arr[windowEnd] == 0) {
                zeroCount++;
            }
            if (zeroCount > k) {
                if (arr[windowStart] == 0) {
                    zeroCount--;
                }
                windowStart++;
            }
            resultLength = Math.max(resultLength, windowEnd - windowStart + 1);
        }
        return resultLength;
    }

    public static void main(String[] args) {
        System.out.println(findLength(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2));
        System.out.println(findLength(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3));
    }
}
