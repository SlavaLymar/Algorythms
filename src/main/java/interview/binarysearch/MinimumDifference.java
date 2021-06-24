package interview.binarysearch;

public class MinimumDifference {

    //     s
    // [4, 6, 10], key = 7
    //     m  e
    //
    // t: O (Log N)
    // space: O (1)
    public static int searchMinDiffElement(int[] arr, int key) {
        int start = 0, end = arr.length - 1, mid;
        while (end - start > 1) {
            mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                return arr[mid];
            } else if (arr[mid] < key) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return Math.abs(arr[start] - key) < Math.abs(arr[end] - key) ? arr[start] : arr[end];
    }

    public static void main(String[] args) {
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
    }
}
