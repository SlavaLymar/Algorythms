package interview.twopointers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubarrayProductLessThanK {

    public static void main(String[] args) {
        System.out.println(findSubarrays(new int[]{2, 5, 3, 10}, 30));
        System.out.println(findSubarrays(new int[]{8, 2, 6, 5}, 50));
    }

    // 2, 5, 3, 10
    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();
        for (int left = 0; left < arr.length; left++) {
            int product = 1;
            int right = left;
            do  {
                product *= arr[right];
                if (product < target) {
                    List<Integer> iList = new LinkedList<>();
                    for (int i = left; i <= right; i++) {
                        iList.add(arr[i]);
                    }
                    subarrays.add(iList);
                }
            } while (product < target && ++right < arr.length);
        }
        return subarrays;
    }
}
