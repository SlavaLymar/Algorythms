package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    //    [-1,0,1,2,-1,-4]
    //
    // 1. [-4,-1,-1,0,1,2]
    //
    //      i  l
    // 2. [-4,-1,-1,0,1,2]
    //                  r
    //
    // t: O (N ^ 2)
    // space: O (1)
    //
    public static List<List<Integer>> threeSum(int[] arr) {
        if (arr.length < 3) return new ArrayList<>();
        Arrays.sort(arr);
        if (arr[0] > 1) return new ArrayList<>();
        List<List<Integer>> triplets = new ArrayList<>();
        if (arr[0] == arr[arr.length - 1] && arr[0] == 0) {
            triplets.add(Arrays.asList(0, 0, 0));
            return triplets;
        }
        for (int i = 0; i < arr.length - 2; i++) {
            int iNumber = arr[i];
            if (i > 0 && arr[i - 1] == iNumber) continue;
            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                int lNumber = arr[left];
                int rNumber = arr[right];
                int sum = lNumber + rNumber + iNumber;
                if (sum == 0) {
                    triplets.add(Arrays.asList(lNumber, rNumber, iNumber));
                    while (left < right && arr[left] == lNumber) left++;
                    while (left < right && arr[right] == rNumber) right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{1,0,-1}));
    }
}
