package leetcode.medium;

public class RemoveDuplicatesFromSortedArrayII {

    //   0. 1. 2. 3. 4. 5. 6. 7. 8.
    // [ 0, 0, 1, 1, 2, 3, 3, 3, 3 ]
    //      i
    //
    //   0. 1. 2. 3. 4. 5
    // [ 1, 1, 1, 2, 2, 3]
    //      i
    //
    //   count = 0
    //   index = 0
    //
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int index = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 0;
            }

            if (count < 2) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicatesFromSortedArrayII().removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }
}
