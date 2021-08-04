package interview;

import java.util.LinkedList;
import java.util.List;

public class SortNNumbers {

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
    private static List<Integer> sort(int[] input) {
        List<Integer> arr = new LinkedList<>();
        arr.add(input[0]);
        int index = 1;
        for (int i = 1; i < input.length; i++) {
            if (input[i] == 0) {
                arr.add(0, input[i]);
                index++;
            } else if (input[i] == 1) {
                arr.add(index++, input[i]);
            } else {
                arr.add(input[i]);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(sort(new int[]{0,1,2,0,2,1,1,0}));
    }
}
