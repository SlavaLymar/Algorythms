package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    /**
     * Suppose the number (n) is 5 and you want to find the 70 sequence (k).
     * Factorial of 5 is 120.
     * Make a list of all integer like (1,2,3,4,5).
     *
     * First Iteration: Divide the 120 permutations(factorial of 5) into 5 (number n) buckets. Like 1-24, 25-48, 49-72,73-96,97-120.
     * We know that 70 will fall in the third bucket. That means the first digit will 3. Remove 3 from the list. Ans is 3
     * Remaining items in list (1,2,4,5)
     *
     * Second Iteration: Now concentrate on the third bucket. Each bucket had 24 members, right.
     * Divide the bucket element into 4 (n-1) sub-buckets like 49-54, 55-60, 61-66, 67-72.
     * 70 will come in the 4 bucket and we have 5 in there. Remove 5 from the list, so it is 35.
     * Remaining items in list (1,2,4)
     *
     * Third Iteration: Divide the forth subbucket in 3 buckets like 67-68,69-70,71-72
     * 70 falls in second bucket second bucket which is 2. Remove 2. So it is 352 and remaining list is 1,4
     *
     * and so on.
     */
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
