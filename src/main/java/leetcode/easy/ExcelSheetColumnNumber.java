package leetcode.easy;

public class ExcelSheetColumnNumber {

    //
    // A -> 1
    // B -> 2
    // C -> 3
    // ...
    // Z -> 26
    // AA -> 27
    //
    // AA -> A + 26 ^ 1 * A
    // AB -> B + 26 ^ 1 * A
    // ZA -> A + 26 ^ 1 * Z
    // ZZ -> Z + 26 ^ 1 * Z = 702
    // AAA -> A + 26 ^ 1 * A + 26 ^ 2 * A = 703
    //
    // t: O (N)
    // space: O (1)
    //
    public int titleToNumber(String columnTitle) {
        int result = 0;
        int length = columnTitle.length();
        for (int i = length - 1; i >= 0; i--) {
            char ch = columnTitle.charAt(i);
            result += this.intFromChar(ch) * Math.pow(26, length - 1 - i);
        }
        return result;
    }


    private int intFromChar(char ch) {
        return ch - 'A' + 1;
    }

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("A"));
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("AB"));
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("ZA"));
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("ZZ"));
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("AAA"));
    }
}
