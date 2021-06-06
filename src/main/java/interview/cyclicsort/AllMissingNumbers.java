package interview.cyclicsort;

import java.util.ArrayList;
import java.util.List;

public class AllMissingNumbers {

    // 2, 3, 1, 8, 2, 3, 5, 1
    // 3, 2, 1, 8, 2, 3, 5, 1
    // 1, 2, 3, 8, 2, 3, 5, 1
    // 1, 2, 3, 1, 2, 3, 5, 8
    // 1, 2, 3, 1, 5, 3, 2, 8
    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return missingNumbers;
        }

        int i = 0;
        while (i < nums.length) {
            int targetIdx = nums[i] - 1;
            if (nums[i] != nums[targetIdx]) {
                swap(nums, i, targetIdx);
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                missingNumbers.add(i + 1);
            }
        }
        return missingNumbers;
    }

    private static void swap(int[] nums, int i, int targetIdx) {
        int tmp = nums[targetIdx]; // 3
        nums[targetIdx] = nums[i];
        nums[i] = tmp;
    }

    public static void main(String[] args) {
        List<Integer> missing = AllMissingNumbers.findNumbers(new int[] { 2, 3, 1, 8, 2, 3, 5, 1 });
        System.out.println("Missing numbers: " + missing);

        missing = AllMissingNumbers.findNumbers(new int[] { 2, 4, 1, 2 });
        System.out.println("Missing numbers: " + missing);

        missing = AllMissingNumbers.findNumbers(new int[] { 2, 3, 2, 1 });
        System.out.println("Missing numbers: " + missing);
    }
}
