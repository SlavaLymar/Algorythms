package leetcode.hard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {

    //
    // i
    // 5,2,6,1
    //
    // helper:
    //   l
    // 1,6
    //   r
    // m
    //
    // 0,1,1,0
    //
    // t: O (N * Log N)
    // space: O (N)
    //
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();

        for (int num : nums) arr.add(num);

        Collections.sort(arr);

        for (int num : nums) {
            int index = binarySearch(arr, num);
            ans.add(index);
            arr.remove(index);
        }

        return ans;
    }

    public int binarySearch(ArrayList<Integer> arr, int target) {
        int start = 0;
        int end = arr.size() - 1;
        int mid = 0;

        while (start <= end) {
            mid = start + ((end - start) / 2);
            int val = arr.get(mid);
            if (val < target) start = mid + 1;
            else end = mid - 1;
        }
        if (arr.get(start) == target) return start;
        return mid;
    }

    public static void main(String[] args) throws IOException {
        CountOfSmallerNumbersAfterSelf countOfSmallerNumbersAfterSelf = new CountOfSmallerNumbersAfterSelf();
        System.out.println(
                countOfSmallerNumbersAfterSelf.countSmaller(
                        new int[]{5, 2, 6, 1}
                )
        );
        System.out.println(
                countOfSmallerNumbersAfterSelf.countSmaller(
                        new int[]{-1}
                )
        );
        System.out.println(
                countOfSmallerNumbersAfterSelf.countSmaller(
                        new int[]{-1, -1}
                )
        );
        System.out.println(
                countOfSmallerNumbersAfterSelf.countSmaller(
                        new int[]{-1, 0}
                )
        );
        System.out.println(
                countOfSmallerNumbersAfterSelf.countSmaller(
                        new int[]{2, 0, 1}
                )
        );
        System.out.println(
                countOfSmallerNumbersAfterSelf.countSmaller(
                        new int[]{26, 78, 27, 100, 33, 67, 90, 23, 66, 5, 38, 7, 35, 23, 52, 22, 83, 51, 98, 69, 81, 32, 78, 28, 94, 13, 2, 97, 3, 76, 99, 51, 9, 21, 84, 66, 65, 36, 100, 41}
                )
        );
    }
}
