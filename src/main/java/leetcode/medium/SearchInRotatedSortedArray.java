package leetcode.medium;

public class SearchInRotatedSortedArray {

    //  l
    // [4, 5, 7, 9, 10, -1, 2]
    //           m          r
    //
    //
    // t: O (Log N)
    // space: O (1)
    //
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1, middle = -1;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (target == nums[middle]) {
                return middle;
            }
            if (nums[left] <= nums[middle]) { // asc
                if (target >= nums[left] && target < nums[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                if (target > nums[middle] && target <= nums[right]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
    }
}
