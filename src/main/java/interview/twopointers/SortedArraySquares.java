package interview.twopointers;

import java.util.Arrays;

public class SortedArraySquares {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(makeSquares(new int[]{-2, -1, 0, 2, 3})));
    }

    // l             r
    // -2, -1, 0, 2, 3
    //  0,  1, 4, 4, 9
    public static int[] makeSquares(int[] arr) {
        int length = arr.length;
        int[] squares = new int[length];
        int left = 0, right = length - 1;
        for (int i = squares.length - 1; i >= 0; i--) {
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            if (leftSquare > rightSquare) {
                squares[i] = leftSquare;
                left++;
            } else {
                squares[i] = rightSquare;
                right--;
            }
        }
        return squares;
    }
}
