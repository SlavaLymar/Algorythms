package leetcode.hard;

import java.util.*;

public class PermutationSequence {

    //
    // n = 3, k = 3
    //
    // 1                            1
    // 2                      12         21
    // 3                312    132   123     321   231   213
    //
    // t: O
    // space: O
    //
    public static String getPermutation(int n, int k) {
        List<StringBuilder> list = new ArrayList<>();
        list.add(new StringBuilder("1"));
        for (int i = 2; i <= n ; i++) {
            List<StringBuilder> inner = new ArrayList<>();
            int size = list.size();
            for (int j = 0; j < fact(i) ; j++) {
                for (int l = i - 1; l >= 0; l--) {
                    StringBuilder sb = new StringBuilder(list.get(j));
                    if (l > size - 1) {
                        sb.append((char) (i + '0'));
                        inner.add(sb);
                    } else {
                        sb.setCharAt(l, (char) (i + '0'));
                        inner.add(sb);
                    }
                }
            }
            list = inner;
        }
        return list.get(k).toString();
    }

    private static int fact(int num) {
        if (num == 1) return 1;
        return num * (fact(num - 1));
    }

    public static void main(String[] args) {
        long time1 = new Date().getTime();
        System.out.println(getPermutation(3,3));
//        System.out.println(getPermutation(4,9));
//        System.out.println(getPermutation(9,331987));
        long time2 = new Date().getTime();
//        System.out.println(time2 - time1);
    }
}
