package leetcode.easy;

public class SearchInsertPosition {

    //             l
    // [1, 3, 5, 6], target = 7
    //           mr
    //     l
    // [1, 3, 5, 6], target = 2
    //  rm
    //
    // t: O (Log N)
    // space: O (1)
    //
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
    }
}
