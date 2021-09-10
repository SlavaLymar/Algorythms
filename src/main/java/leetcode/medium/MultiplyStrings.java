package leetcode.medium;

public class MultiplyStrings {

    //
    //   i
    //  12  128     =         56
    //        i
    //
    //  128
    //   12
    //  256
    //
    // t: O (N1 * N2)
    // space: O (N1 * N2)
    //
    public static String multiply(String num1, String num2) {
        // Array length should at most equal to sum of digits. Two three digit numbers can have at most 6 digits as product: 999 *999 = 9989001
        int[] val = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            // k will start off at index 0 but the starting point of k will increment everytime we return to the outer loop
            int k = num1.length() - 1 - i;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int x = num1.charAt(i) - '0';
                int y = num2.charAt(j) - '0';
                int z = x * y + val[k];
                val[k] = z % 10;
                // no need for a carry variable as we keep track of it in the next index of the integer array
                val[k + 1] += z / 10;
                k++;
            }
        }
        // Ignore all leading zeroes. We set end > 0 instead of end >=0 because the end solution could be "0"
        int end = val.length - 1;
        while (end > 0 && val[end] == 0) {
            end--;
        }
        // build final string in reverse order of our integer array
        StringBuilder sb = new StringBuilder();
        for (int i = end; i >= 0; i--) {
            sb.append(val[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("0", "0"));
        System.out.println(multiply("999", "999"));
        System.out.println(multiply("123", "456"));
        System.out.println(multiply("9876", "1234"));
        System.out.println(multiply("123456789", "987654321"));
    }
}