package leetcode.easy;

public class RemoveDuplicatesFromSortedArray {

    //
    // nums = [0,0,1,1,1,2,2,3,3,4]
    //
    // [0,1,2,3,4,2,2,3,3,4]
    //
    // t: O (N)
    // space: O (1)
    //
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int curNum = nums[0], currentIdx = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != curNum) {
                curNum = nums[i];
                nums[currentIdx++] = nums[i];
            }
        }
        return currentIdx;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}
