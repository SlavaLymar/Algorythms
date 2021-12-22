package leetcode.easy;

public class AddBinary {

    //
    // f + f = f,
    // f + t = t,
    // t + f = t,
    // t + t = f, mem = true
    // t + t + mem(true) = t, mem = true.
    //
    //  		1	0	1	1
    //+    1	0	0	1	1
    //     1	1	1	1	0
    //
    //                                                 i
    // arr = ['f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f']
    //
    // t: O (a * b)
    // space: O (1)
    //
    public String addBinary(String a, String b) {
        boolean[] arr = new boolean[a.length() + b.length()];
        boolean mem = false;
        int idxA = a.length() - 1;
        int idxB = b.length() - 1;
        int arrIdx = arr.length - 1;
        while (idxA >= 0 || idxB >= 0) {
            int chA = 0, chB = 0;
            if (idxA >= 0) {
                chA = a.charAt(idxA) - '0';
            }
            if (idxB >= 0) {
                chB = b.charAt(idxB) - '0';
            }
            int result = chA + chB + (mem ? 1 : 0);
            arr[arrIdx] = result % 2 != 0;
            mem = result >= 2;
            arrIdx--;
            idxA--;
            idxB--;
        }
        if (mem) arr[arrIdx] = true;
        StringBuilder sb = new StringBuilder();
        boolean start = false;
        for (boolean value : arr) {
            if (value) start = true;
            if (start) sb.append(value ? '1' : '0');
        }
        return start ? sb.toString() : "0";
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("0", "0"));
        System.out.println(new AddBinary().addBinary("11", "1"));
        System.out.println(new AddBinary().addBinary("1011", "10011"));
    }
}
