package leetcode.medium;

public class FindTheDuplicateNumber {

    //             i
    // -1,-3,-4,-2,2
    //
    // t: O (N)
    // space: O (1)
    //
    public int findDuplicate(int[] nums) {
        if (nums == null) return -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0) {
                return Math.abs(nums[i]);
            } else {
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(
                new FindTheDuplicateNumber().findDuplicate(new int[]{1,3,4,2,2})
        );
        System.out.println(
                new FindTheDuplicateNumber().findDuplicate(new int[]{3,1,3,4,2})
        );
    }
}
