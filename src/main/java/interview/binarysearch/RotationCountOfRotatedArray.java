package interview.binarysearch;

public class RotationCountOfRotatedArray {

    //  s
    // [6, 7, 1, 2, 3, 4, 5]
    //           m        e
    //
    // t: O (Log N)
    // space: O (1)
    public static int countRotations(int[] arr) {
        int start = 0, end = arr.length - 1, mid = start + (end - start) / 2;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (arr[start] == arr[mid]) {
                start = mid + 1;
            } else if (arr[start] < arr[mid]) {
                start = mid;
            } else {
                end = mid;
                mid = mid - 1;
            }
        }
        if (arr[mid] > arr[start]) {
            return start;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 3, 3, 7, 3 }));
        System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 10, 15, 1, 3, 8 }));
        System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 4, 5, 7, 9, 10, -1, 2 }));
        System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 1, 3, 8, 10 }));
    }
}
