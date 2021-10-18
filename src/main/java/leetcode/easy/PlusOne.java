package leetcode.easy;

import java.util.Arrays;

public class PlusOne {

    //
    // [1,2,3] -> [1,2,4]
    // [1,2,9] -> [1,3,0]
    // [9,9] -> [1,0,0]
    //
    // t: O (N)
    // space: O (N)
    //
    public int[] plusOne(int[] digits) {
        boolean plusOne = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            int num = digits[i] + 1;
            int div = num - 10;
            if (div == 0) {
                digits[i] = 0;
                plusOne = true;
            } else {
                plusOne = false;
                digits[i] = num;
                break;
            }

        }
        return plusOne ? newArray(digits): digits;
    }

    public int[] newArray(int[] digits) {
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        for (int i = 1; i < result.length; i++) {
            result[i] = digits[i - 1];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{0})));
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{1,2,3})));
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{1,2,9})));
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{9})));
    }
}
