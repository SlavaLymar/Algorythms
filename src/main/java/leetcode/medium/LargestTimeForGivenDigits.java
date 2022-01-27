package leetcode.medium;

public class LargestTimeForGivenDigits {

    int maxTime = -1;
    //        i
    // arr = [1, 2, 3, 4]
    //
    //
    //
    //
    //
    public String largestTimeFromDigits(int[] arr) {
        this.permutation(arr, 0);
        if (this.maxTime == -1) return "";
        else return String.format("%02d:%02d", this.maxTime / 100, this.maxTime - ((this.maxTime / 100) * 100));
    }

    private void permutation(int[] arr, int start) {
        if (start == arr.length) {
            this.buildTime(arr);
            return;
        }
        for (int i = start; i < arr.length; i++) {
            this.swap(arr, start, i);
            this.permutation(arr, start + 1);
            this.swap(arr, start, i);
        }
    }

    private void buildTime(int[] arr) {
        if (arr[0] * 10 +  arr[1] < 24 && arr[2] * 10 + arr[3] < 59) {
            int time =
                    ((arr[0] * 10 + arr[1]) * 100) + (arr[2] * 10 + arr[3]);
            this.maxTime = Math.max(this.maxTime, time);
        }
    }

    private void swap(int[] arr, int from, int to) {
        if (from != to) {
            int tmp = arr[from];
            arr[from] = arr[to];
            arr[to] = tmp;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LargestTimeForGivenDigits().largestTimeFromDigits(new int[]{1,2,3,4}));
    }
}
