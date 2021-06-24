package interview.binarysearch;

public class BinarySearch {

    //  s
    // [1, 2, 3, 4, 5, 6, 7] , key = 5
    //           m        e
    //
    //  s
    // [4, 6, 10], key = 10
    //     m   e
    //
    // t: O (log N)
    // space: O (1)
    public static int search(int[] arr, int key) {
        int result = -1;
        if (arr == null || arr.length == 0) {
            return result;
        }
        int start = 0, end = arr.length - 1, middle;
        while (start <= end) {
            middle = start + (end - start) / 2;
            if (arr[middle] == key) {
                result = middle;
                break;
            }
            boolean isAscending = arr[start] < arr[middle];
            if (arr[middle] > key) {
                end = isAscending ? middle - 1 : end;
                start = isAscending ? start : middle + 1;
            } else {
                start = isAscending ? middle + 1 : start;
                end = isAscending ? end : middle - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(BinarySearch.search(new int[] { 4, 6, 10 }, 10));
        System.out.println(BinarySearch.search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
        System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 10));
        System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 4));
    }
}
