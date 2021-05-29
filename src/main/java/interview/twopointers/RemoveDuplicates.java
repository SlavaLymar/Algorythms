package interview.twopointers;

public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(remove(new int[]{2, 3, 3, 3, 6, 9, 9}));

        int[] arr = new int[] { 3, 2, 3, 6, 3, 10, 9, 3 };
        System.out.println(remove(arr, 3));

        arr = new int[] { 2, 11, 2, 2, 1 };
        System.out.println(remove(arr, 2));
    }

    // i
    // 2, 3, 6, 9, 6, 9, 9
    // n
    public static int remove(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int nextNonDuplicate = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[nextNonDuplicate - 1]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }
        return nextNonDuplicate;
    }

    //  i
    // 2, 11, 2, 2, 1
    // n
    public static int remove(int[] arr, int key) {
        if (arr == null) {
            return 0;
        }
        int lastNonKey = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != key) {
                arr[lastNonKey++] = arr[i];
            }
        }
        return lastNonKey;
    }
}
