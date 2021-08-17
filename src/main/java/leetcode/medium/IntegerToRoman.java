package leetcode.medium;

public class IntegerToRoman {

    public static String intToRoman(int num) {
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            if (num / values[i] > 0) {
                int n = num / values[i];
                for (int j = 0; j < n; j++) {
                    num -= values[i];
                    sb.append(symbols[i]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
}
