package leetcode.hard;

public class FirstMissingPositive {

    // 1.
    //  i
    // [3,4,-1,1]
    //     i
    // [-1,4,3,1]
    //       i
    // [-1,4,3,1]
    //         i
    // [-1,4,3,1]
    // [1,4,3,-1]
    //
    // 2.
    //    i
    // [1,4,3,-1] => 2
    //
    // t: O (n)
    // space: O (1)
    //
    public static int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int num = nums[i];
            if (num > 0 && num < nums.length && num != nums[num - 1]) {
                swap(nums, i, num - 1);
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (i != nums[i] - 1) return i + 1;
        }
        return i + 1;
    }

    public static void swap(int[] nums, int from, int to) {
        int tmp = nums[from];
        nums[from] = nums[to];
        nums[to] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
    }
}
