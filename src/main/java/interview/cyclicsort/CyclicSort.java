package interview.cyclicsort;

public class CyclicSort {

    // Input: [3, 1, 5, 4, 2]
    // Output: [1, 2, 3, 4, 5]
    public static void sort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int targetIdx = nums[i] - 1;
            if (nums[i] != nums[targetIdx]) {
                swap(nums, i, targetIdx);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] nums, int i, int targetIdx) {
        int tmp = nums[targetIdx]; // 5
        nums[targetIdx] = nums[i];
        nums[i] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 1, 5, 4, 2 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 2, 6, 4, 3, 1, 5 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 1, 5, 6, 4, 3, 2 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
}
