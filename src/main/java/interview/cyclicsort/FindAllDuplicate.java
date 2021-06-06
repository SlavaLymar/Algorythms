package interview.cyclicsort;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicate {

    // 5, 4, 7, 2, 3, 5, 3
    // 3, 4, 7, 2, 5, 5, 3
    // 7, 4, 3, 2, 5, 5, 3
    // 3, 4, 3, 2, 5, 5, 7 => 3
    // 3, 2, 3, 4, 5, 5, 7
    // 3, 2, 3, 4, 5, 5, 7 => 5
    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> duplicateNumbers = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) { // 7 != 7
                if (nums[i] != nums[nums[i] - 1]) { // 5 != 5
                    swap(nums, i, nums[i] - 1);
                } else {
                    duplicateNumbers.add(nums[i]);
                    i++;
                }
            } else {
                i++;
            }
        }
        return duplicateNumbers;
    }

    private static void swap(int[] nums, int i, int targetIdx) {
        int tmp = nums[targetIdx];
        nums[targetIdx] = nums[i];
        nums[i] = tmp;
    }

    public static void main(String[] args) {
        List<Integer> duplicates = FindAllDuplicate.findNumbers(new int[]{3, 4, 4, 5, 5});
        System.out.println("Duplicates are: " + duplicates);

        duplicates = FindAllDuplicate.findNumbers(new int[]{5, 4, 7, 2, 3, 5, 3});
        System.out.println("Duplicates are: " + duplicates);
    }
}
