package leetcode;

import java.util.*;

public class SortNNumbers {

    public static final int RED_COLOUR = 0;
    public static final int BLUE_COLOUR = 1;
    public static final int GREEN_COLOUR = 2;

    //
    // [2,0,2,1,1,0]
    //
    // red = 0, blue - 1, green - 2
    //
    // [2] index = 1
    //
    // t: O (N)
    // space: O (N)
    //
    private static int[] sort(int[] input) {
        int redCount = 0;
        int blueCount = 0;
        int greenCount = 0;

        for (int num : input) {
            if (num == 0) {
                redCount++;
            } else if (num == 1) {
                blueCount++;
            } else {
                greenCount++;
            }
        }
        int[] arr = new int[input.length];
        int index = 0;
        for (int i = 0; i < redCount; i++) {
            arr[index++] = RED_COLOUR;
        }
        for (int i = 0; i < blueCount; i++) {
            arr[index++] = BLUE_COLOUR;
        }
        for (int i = 0; i < greenCount; i++) {
            arr[index++] = GREEN_COLOUR;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{0, 1, 2, 0, 2, 1, 1, 0})));
    }
}
