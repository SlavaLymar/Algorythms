package interview.twopointers;

import java.util.Arrays;

public class DutchFlag {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 0, 1, 2, 0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // i
    // l
    // 2, 2, 0, 1, 2, 0
    //                h
    public static void sort(int[] arr) {
        int low = 0, high = arr.length - 1;
        for (int i = 0; i <= high;) {
            if (arr[i] == 0) {
              swap(arr, i, low);
              i++;
              low++;
            } else if (arr[i] == 1) {
                i++;
            } else {
                swap(arr, i, high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
