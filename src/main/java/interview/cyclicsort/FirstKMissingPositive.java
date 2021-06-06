package interview.cyclicsort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FirstKMissingPositive {

    // Input: [3, -1, 4, 5, 5], k=3
    // Output: [1, 2, 6]
    //
    // 3, -1, 4, 5, 5
    // 4, -1, 3, 5, 5
    // 5, -1, 3, 4, 5
    // 5, -1, 3, 4, 5 => if (nums[i] != i + 1) => i + 1
    public static List<Integer> findNumbers(int[] nums, int k) {
        int i = 0;
        while (i < nums.length) {
            int num = nums[i];
            if (num > 0 && num <= nums.length && num != nums[num - 1]) {
                swap(nums, i, num - 1);
            } else {
                i++;
            }
        }
        List<Integer> missingNumbers = new ArrayList<>();
        Set<Integer> numsSet = new HashSet<>(nums.length);
        for (i = 0; i < nums.length && missingNumbers.size() != k; i++) {
            if (nums[i] != i + 1) {
                numsSet.add(nums[i]);
                missingNumbers.add(i + 1);
            }
        }
        for (i = 1; missingNumbers.size() != k; i++) {
            int candidateNum = i + nums.length;
            if (!numsSet.contains(candidateNum)) {
                missingNumbers.add(candidateNum);
            }
        }
        return missingNumbers;
    }

    private static void swap(int[] nums, int i, int targetIdx) {
        int tmp = nums[targetIdx];
        nums[targetIdx] = nums[i];
        nums[i] = tmp;
    }

    public static void main(String[] args) {
        List<Integer> missingNumbers = FirstKMissingPositive.findNumbers(new int[]{3, -1, 4, 5, 5}, 3);
        System.out.println("Missing numbers: " + missingNumbers);

        missingNumbers = FirstKMissingPositive.findNumbers(new int[]{2, 3, 4}, 3);
        System.out.println("Missing numbers: " + missingNumbers);

        missingNumbers = FirstKMissingPositive.findNumbers(new int[]{-2, -3, 4}, 2);
        System.out.println("Missing numbers: " + missingNumbers);
    }
}
