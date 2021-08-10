public class MaxSumContiguesSubarray {

    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{-2,2,5,-11,6}));
    }

    //    v
    // -2,2,5,-11,6
    // cur_max = -2, max = -2
    // cur_max = max(cur_max + arr[i], arr[i])
    //
    // t: O (N)
    // space: O (1)
    //
    private static int maxSum(int[] input) {
        int max = input[0], curMax = max;
        for (int i = 1; i < input.length; i++) {
            curMax = Math.max(input[i] + curMax, input[i]);
            max = Math.max(curMax, max);
        }
        return max;
    }
}
