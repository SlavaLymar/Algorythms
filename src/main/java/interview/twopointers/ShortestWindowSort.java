package interview.twopointers;

public class ShortestWindowSort {

    public static void main(String[] args) {
        System.out.println(sort(new int[]{1, 2, 3}));
    }

    // l
    // 1, 2, 90, 5, -4, -6, 4, 10, 11
    //                              r
    public static int sort(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] < arr[left + 1]) {
                left++;
            } else if (arr[right] > arr[right - 1]) {
                right--;
            } else {
                int min = arr[left], max = arr[right];
                for (int i = left; i <= right; i++) {
                    min = Math.min(min, arr[i]);
                    max = Math.max(max, arr[i]);
                }
                while (left > 0 && arr[left - 1] > min) {
                    left--;
                }
                while (right < arr.length - 1 && arr[right + 1] < max) {
                    right++;
                }
                break;
            }
        }
        int distance = right - left;
        return distance == 0 ? 0: distance + 1;
    }
}
