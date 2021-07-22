package interview.dp;

public class PartitionSetDiff {

    //
    // Input: {1, 2, 7, 1, 5}
    // Output: 0
    //
    // sum = 16
    // if sum = sum/2
    //
    //       0  1. 2. 3. 4. 5. 6. 7. 8 - s
    // 1. 0. t. t. f. f. f. f. f. f. f
    // 2. 1. t. t. t. t. f. f. f. f. f
    // 7. 2. t. t. t. t. f. f. f. t. t
    // 1. 3. t. t. t. t. t. f. f. f. t
    // 5. 4. t. t. t. t. t. t. t. t. t
    // i
    //
    // max(s) where arr[s] == true
    // Answer: sum - 2 * max(s) = 0
    //
    // t: O (N + N + N * S) => O (N * (2 + S)) => O (N * S)
    // space: O (S)
    //
    public int canPartition(int[] num) {
        if (num.length == 1) return num[0];
        int sum = 0;
        for (int n : num) sum += n;
        int arrLength = sum/2 + 1;
        boolean[] arr = new boolean[arrLength];
        for (int s = 0; s <= num[0]; s++) arr[s] = true;
        int maxSum = 0;
        for (int i = 1; i < num.length; i++) {
            for (int s = arrLength - 1; s > 0; s--) {
                if (!arr[s] && s >= num[i]) {
                    arr[s] = arr[s - num[i]];
                }
                if (arr[s]) maxSum = Math.max(maxSum, s);
            }
        }
        return sum - (2 * maxSum);
    }

    public static void main(String[] args) {
        PartitionSetDiff ps = new PartitionSetDiff();
        int[] num = {1, 2, 3, 9};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps.canPartition(num));
    }
}
