package interview.cyclicsort;

public class FindCorruptNums {

    // 3, 1, 2, 3, 6, 4
    // 2, 1, 3, 3, 6, 4
    // 1, 2, 3, 3, 6, 4
    // 1, 2, 3, 3, 4, 6
    // 1, 2, 3, 4, 3, 6
    public static int[] findNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }
        return new int[]{-1, -1};
    }

    private static void swap(int[] nums, int i, int targetIdx) {
        int tmp = nums[targetIdx]; // 2
        nums[targetIdx] = nums[i];
        nums[i] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = FindCorruptNums.findNumbers(new int[]{3, 1, 2, 5, 2});
        System.out.println(nums[0] + ", " + nums[1]);
        nums = FindCorruptNums.findNumbers(new int[]{3, 1, 2, 3, 6, 4});
        System.out.println(nums[0] + ", " + nums[1]);
    }
}
