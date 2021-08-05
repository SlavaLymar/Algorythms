package interview.dp;

public class TargetSum {

    //
    // Input: {1, 1, 2, 3}, S=1
    //
    //     0  1  2  3
    // 1 0 1. 1. 0. 0.
    // 1 1 1. 2. 1. 0.
    // 2 2 1. 2. 2. 2.
    // 3 3 1. 2. 2. 3.
    //
    // t: O (N * S)
    // space: O (S)
    //
    public int findTargetSubsets(int[] num, int s) {
        int sum = 0;
        for (int n : num) sum += n;
        if (sum < s || (s + sum) % 2 == 1) {
            return 0;
        }
        int[] arr = new int[(s + sum) / 2];
        arr[0] = 1;
        if (num[0] < arr.length) {
            arr[num[0]] = 1;
        }
        for (int i = 1; i < num.length; i++) {
            for (int a = arr.length - 1; a > 0; a--) {
                if (a >= num[i]) {
                    arr[a] += arr[a - num[i]];
                }
            }
        }
        return arr[arr.length - 1];
    }

    public static void main(String[] args) {
        TargetSum ts = new TargetSum();
        int[] num = {1, 1, 2, 3};
        System.out.println(ts.findTargetSubsets(num, 1));
        num = new int[]{1, 2, 7, 1};
        System.out.println(ts.findTargetSubsets(num, 9));
    }
}
