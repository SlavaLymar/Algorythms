package interview.twopointers;

import java.util.*;

public class QuadrupleSumToTarget {

    public static void main(String[] args) {
        System.out.println(searchQuadruplets(new int[]{4, 1, 2, -1, 1, -3}, 1));
        System.out.println(searchQuadruplets(new int[]{2, 0, -1, 1, -2, 2}, 2));
    }

    //
    // 4, 1, 2, -1, 1, -3
    //  i      l
    // -3, -1, 1, 1, 2, 4
    //      j           r
    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> quadruplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 3; i++) {
            for (int j = i + 1; j < arr.length - 2; j++) {
                int left = j + 1, right = arr.length - 1;
                while (left < right) {
                    int iSum = arr[i] + arr[j] + arr[left] + arr[right];
                    if (iSum == target) {
                        quadruplets.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
                        left++;
                        right--;
                    } else if (iSum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }
}
