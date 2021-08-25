package interview.twopointers;

import java.util.*;

public class TripletSumCloseToTarget {

    public static void main(String[] args) {
        System.out.println(searchTriplet(new int[]{-1,2,1,-4}, 1));
        System.out.println(searchTriplet(new int[]{-3, -1, 1, 2}, 1));
        System.out.println(searchTriplet(new int[]{1, 0, 1, 1}, 3));
    }

    //    i
    // 0, 1, 1, 1
    // l        r
    public static int searchTriplet(int[] arr, int targetSum) {
        if (arr == null || arr.length < 3)
            throw new IllegalArgumentException();

        Arrays.sort(arr);
        int smallestDifference = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                int targetDiff = targetSum - arr[i] - arr[left] - arr[right];
                if (targetDiff == 0)
                    return targetSum - targetDiff;
                if (Math.abs(targetDiff) < Math.abs(smallestDifference)
                        || (Math.abs(targetDiff) == Math.abs(smallestDifference) && targetDiff > smallestDifference))
                    smallestDifference = targetDiff;
                if (targetDiff > 0)
                    left++;
                else
                    right--;
            }
        }
        return targetSum - smallestDifference;
    }
}
