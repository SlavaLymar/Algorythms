package interview.cyclicsort;

public class FirstSmallestMissingPositive {

    // -3, 1, 5, 4, 2 => nums[i] != nums[nums[i] - 1] => -3 !=
    // 1, -3, 5, 4, 2
    // 1, -3, 2, 4, 5
    // 1, 2, -3, 4, 5  => nums[i] != i + 1
    public static int findNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int targetIdx) {
        int tmp = nums[targetIdx];
        nums[targetIdx] = nums[i];
        nums[i] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(FirstSmallestMissingPositive.findNumber(new int[]{-3, 1, 5, 4, 2}));
        System.out.println(FirstSmallestMissingPositive.findNumber(new int[]{3, -2, 0, 1, 2}));
        System.out.println(FirstSmallestMissingPositive.findNumber(new int[]{3, 2, 5, 1}));
    }
}
