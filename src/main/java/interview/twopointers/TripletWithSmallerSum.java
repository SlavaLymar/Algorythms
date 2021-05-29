package interview.twopointers;

import java.util.Arrays;

public class TripletWithSmallerSum {

    public static void main(String[] args) {
        System.out.println(searchTriplets(new int[]{-1, 0, 2, 3}, 3));
        System.out.println(searchTriplets(new int[]{-1, 4, 2, 1, 3}, 5));
        System.out.println(searchTriplets(new int[]{-11, -1, 0, 4, 2, 1, 3, 10, 11}, 5));
    }


    // -1, 4, 2, 1, 3
    // O(N log N)
    //  l
    // -1, 1, 2, 3, 4
    //              r
    public static int searchTriplets(int[] arr, int target) {
        int count = 0;
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        while (right - left >= 2) {
            int lNumber = arr[left], rNumber = arr[right], sum = lNumber + rNumber;
            for (int iRight = right - 1; iRight > left ; iRight--) {
                if (sum + arr[iRight] < target) {
                    count += iRight - left;
                    break;
                }
            }
            if (sum < target) {
                right--;
            } else {
                left++;
            }
        }
        return count;
    }
}
