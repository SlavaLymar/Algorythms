package interview.binarysearch;

public class FindRange {

    //      s
    // { 4, 6, 6, 6, 9 }, 6
    //         m  e
    //
    // t: O (Log N)
    // space: O (1)
    public static int[] findRange(int[] arr, int key) {
        int[] result = new int[] { -1, -1 };
        if (arr == null) {
            return result;
        }
        int start = 0, end = arr.length - 1, mid;
        boolean firstIn = false;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                if (!firstIn) {
                    start = mid;
                    end = mid;
                    firstIn = true;
                }
                boolean exit = true;
                if (start > 1 && arr[start - 1] == key) {
                    start--;
                    exit = false;
                }
                if (end < arr.length && arr[end + 1] == key) {
                    end++;
                    exit = false;
                }
                if (exit) {
                    break;
                }
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (arr[start] == key && arr[end] == key) {
            result = new int[]{ start, end };
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = FindRange.findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    }
}
