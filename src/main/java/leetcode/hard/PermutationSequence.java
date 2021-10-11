package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    //
    // 1                1
    // 2            12      21 -> sort
    // 3  123 132 312      213 231 321 -> sort
    //    123                   132 213 231 312 321
    // 4  4123 1423 1243 1234
    //
    //
    // [123, 132, 213]
    //
    public static String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> list = new ArrayList<>();
        for (int a = 1; a <= n; a++) {
            fact = fact * a;
            list.add(a);
        }
        StringBuilder sb = new StringBuilder();

        for (int a = n; a >= 1; a--) {
            fact = fact / a;                         // Number of elements in each bucket
            int divison = k / fact;                  // The bucket the sequence falls
            int modu = k % fact;
            if (modu == 0) divison = divison - 1;     // Special Case
            int rem = list.get(divison);
            list.remove(divison);
            k = k - (fact * divison);
            sb.append(rem);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
//        System.out.println(getPermutation(4, 9));
//        System.out.println(getPermutation(9, 135401));
    }
}
