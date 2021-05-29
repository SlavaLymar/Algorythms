package interview.twopointers;

import java.util.*;

public class TripletSumCloseToTarget {

    public static void main(String[] args) {
        System.out.println(searchTriplet(new int[]{-2, 0, 1, 2}, 2));
        System.out.println(searchTriplet(new int[]{-3, -1, 1, 2}, 1));
        System.out.println(searchTriplet(new int[]{1, 0, 1, 1}, 3));
    }

    //    i
    // 0, 1, 1, 1
    // l        r
    public static int searchTriplet(int[] arr, int targetSum) {
        if (arr == null || arr.length < 3) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(arr);
        int minDifference = Integer.MAX_VALUE;
        int left = 0, right = arr.length - 1;
        while (right - left >= 2) {
            int lNumber = arr[left];
            int rNumber = arr[right];
            int sum = lNumber + rNumber;

            int iRight = right - 1;
            while (iRight > left && Math.abs(sum + arr[iRight]) <= targetSum) {
                minDifference = Math.min(minDifference, targetSum - Math.abs(sum + arr[iRight--]));
            }
            int iLeft = left + 1;
            while (right < iLeft && Math.abs(sum + arr[iLeft]) > targetSum) {
                minDifference = Math.min(minDifference, targetSum - Math.abs(sum + arr[iLeft++]));
            }

            if (sum < targetSum) {
                left++;
            } else {
                right--;
            }
        }
        return targetSum - minDifference;
    }
}
