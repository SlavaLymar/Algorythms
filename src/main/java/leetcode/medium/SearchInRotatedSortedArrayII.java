package leetcode.medium;

public class SearchInRotatedSortedArrayII {

    //  s        m
    // [2, 5, 6, 0, 0, 1, 2], target = 3
    //                    e
    //     s  m
    // [1, 0, 1, 1, 1], target = 0
    //     e
    //
    // t: O (Log N)
    // space: O (1)
    //
    public static boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > nums[start]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (nums[mid] < nums[start]) {
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                start += 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 0, 1, 1, 1}, 0));
    }
}
