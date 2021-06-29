package interview.binarysearch;

public class SearchBitonicArray {

    //  s
    // [1, 3, 8, 4, 3], key=4
    //        m     e
    //
    // t: O (Log N + 2 * Log N) => Log N * (1 + 2) => Log N
    // space: O (1)
    public static int search(int[] arr, int key) {
        int result = -1;
        if (arr == null || arr.length == 0) {
            return result;
        }
        int top = findMax(arr);
        if (arr[top] != key) {
            result = searchInSubArr(arr, 0, top, key, true);
            if (result == -1) {
                result = searchInSubArr(arr, top, arr.length - 1, key, false);
            }
        } else {
            result = top;
        }
        return result;
    }

    private static int findMax(int[] arr) {
        int start = 0, end = arr.length - 1, mid;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    // s
    // 8, 4, 3 ... key = 4
    //    m  e
    public static int searchInSubArr(int[] arr, int start, int end, int key, boolean isAsc) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                start = isAsc ? mid + 1 : start;
                end = isAsc ? end : mid - 1;
            } else {
                start = isAsc ? start : mid + 1;
                end = isAsc ? mid - 1 : end;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 4, 3 }, 4));
        System.out.println(SearchBitonicArray.search(new int[] { 3, 8, 3, 1 }, 8));
        System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 12 }, 12));
        System.out.println(SearchBitonicArray.search(new int[] { 10, 9, 8 }, 10));
    }
}
