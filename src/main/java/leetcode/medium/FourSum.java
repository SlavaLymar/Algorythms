package leetcode.medium;

import java.util.*;

public class FourSum {

    //
    // nums = [1,0,-1,0,-2,2], target = 0
    //
    //   i
    // [-2, -1, 0, 0, 1, 2]
    //       j
    //          l        r
    // t: O (N ^ 3)
    // space: O (1)
    //
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue; //avoid duplicates

            for (int j = i + 1; j < nums.length; j++){
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // avoid duplicates
                int left = j + 1, right = nums.length - 1;

                while (left < right){
                    int curSum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (curSum < target) {
                        left++;
                    } else if (curSum > target) {
                        right--;
                    } else { // curSum == target
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // avoid duplicates
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(fourSum(new int[]{2, 2, 2, 2, 2}, 8));
        System.out.println(fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0));
        System.out.println(fourSum(new int[]{-3,-1,0,2,4,5}, 0));
        System.out.println(fourSum(new int[]{-2,-1,-1,1,1,2,2}, 0));
        System.out.println(fourSum(new int[]{-3,-1,0,2,4,5}, 2));
    }
}
