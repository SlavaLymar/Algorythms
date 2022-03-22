package leetcode.medium;

public class MissingNumber {

    //
    // [2,0,1]
    // [1,0,2]
    // [0,1,2]
    //
    // t: O (N)
    // space: O (1)
    //
    public int missingNumber(int[] nums) {
        if (nums == null) return -1;

        int length = nums.length;
        for (int i = 0; i < nums.length; ) {
            int num = nums[i];
            if (num == i || num >= length) {
                i++;
            } else {
                this.swap(nums, num, i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }

        return length;
    }

    private void swap(int[] nums, int num, int i) {
        int tmp = nums[num];
        nums[num] = num;
        nums[i] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(
                new MissingNumber().missingNumber(new int[]{9,6,4,2,3,5,7,0,1})
        );
    }
}
