package interview.binarysearch;

public class SearchRotatedArray {

    //  s
    // [19, 20, 1, 3, 8, 16, 17, 18], key = 19
    //             m              e
    //
    // t: O (Log N)
    // space: O (1)
    public static int search(int[] arr, int key) {
        int result = -1;
        if (arr == null || arr.length == 0) return result;
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                result = mid;
                break;
            } else if (arr[start] <= arr[mid]) {
                if (key <= arr[start] && key > arr[mid]) {
                    end = mid - 1;
                } else start = mid + 1;
            } else {
                if (key > arr[mid] && key <= arr[end]) {
                    start = mid + 1;
                } else end = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(SearchRotatedArray.search(new int[] { 10, 15, 1, 3, 8 }, 15));
        System.out.println(SearchRotatedArray.search(new int[] { 4, 5, 7, 9, 10, -1, 2 }, 10));
    }
}
