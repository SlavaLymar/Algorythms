package interview.cyclicsort;

public class MissingNumber {

    // 8, 3, 5, 2, 4, 6, 0, 1
    // 1, 3, 5, 2, 4, 6, 0, 8
    //
    public static int findMissingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
            i++;
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }
        return nums.length;
    }

    private static void swap(int[] nums, int i, int targetIdx) {
        int tmp = nums[targetIdx];
        nums[targetIdx] = nums[i];
        nums[i] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(MissingNumber.findMissingNumber(new int[] { 4, 0, 3, 1 }));
        System.out.println(MissingNumber.findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
    }
}
