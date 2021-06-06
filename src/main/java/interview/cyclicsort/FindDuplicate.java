package interview.cyclicsort;

public class FindDuplicate {

    // 1, 4, 4, 3, 2
    // 1, 3, 4, 4, 2
    // 1, 4, 3, 4, 2 => 4
    //
    public static int findNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                if (nums[i] != nums[nums[i] - 1]) {
                    swap(nums, i, nums[i] - 1);
                } else {
                    return nums[i];
                }
            } else {
                i++;
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
        System.out.println(FindDuplicate.findNumber(new int[] { 1, 4, 4, 3, 2 }));
        System.out.println(FindDuplicate.findNumber(new int[] { 2, 1, 3, 3, 5, 4 }));
        System.out.println(FindDuplicate.findNumber(new int[] { 2, 4, 1, 4, 4 }));
    }
}
