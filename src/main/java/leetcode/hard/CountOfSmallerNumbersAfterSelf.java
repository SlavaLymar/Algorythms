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
    // l
    // 1,2,5,6
    //       r
    //   m
    //
    // 2,1,1,0
    //
    // t: O (N * Log N)
    // space: O (N)
    //
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        ArrayList<Integer> helper = new ArrayList<>();
        for (int num : nums) helper.add(num);
        Collections.sort(helper);
        for (int num : nums) {
            int index = binarySearch(helper, num);
            answer.add(index);
            helper.remove(index);
        }
        return answer;
    }

    public int binarySearch(ArrayList<Integer> helper, int target) {
        int left = 0,  right = helper.size() - 1, mid = 0;
        while (left <= right) {
            mid = (right + left) / 2;
            if (helper.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (helper.get(left) == target) return left;
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
