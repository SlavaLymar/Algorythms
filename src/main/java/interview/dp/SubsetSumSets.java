package interview.dp;

public class SubsetSumSets {

    //
    // {1, 1, 2, 3}, S=4
    //
    //      0  1  2  3  4 - s
    // 1 0  1  1  0  0  0
    // 1 1  1  2  1  0  0
    // 2 2  1  2  2  2  1
    // 3 3  1  2  2  3  3
    //   i
    //
    // t: O (N * S)
    // space: O (S)
    //
    static int countSubsets(int[] num, int sum) {
        if (num.length == 0 && sum != 0) return 0;
        int[] arr = new int[sum + 1];
        arr[0] = 1;
        if (num[0] <= sum) {
            arr[num[0]] = num[0];
        }

        for (int i = 1; i < num.length; i++) {
            if (num[i] > sum) continue;
            for (int s = arr.length - 1; s > 0; s--) {
                if (s >= num[i]) {
                    arr[s] = arr[s] + arr[s - num[i]];
                }
            }
        }
        return arr[arr.length - 1];
    }

    public static void main(String[] args) {
        SubsetSumSets ss = new SubsetSumSets();
        int[] num = { 1, 1, 2, 3 };
        System.out.println(ss.countSubsets(num, 4));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.countSubsets(num, 9));
    }
}
