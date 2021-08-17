package leetcode.medium;

public class ZigZagConversion {

    //
    // s = "PAYPALISHIRING", numRows = 4
    //
    // 0 - level
    //   +6  +6  = (numRows - 1) * 2
    // P  I  N
    //
    // 1 - level
    //   +4  +2  +4  +2  +4
    // A  L   S  I   G
    //
    // 2 - level
    //    +2  +4  +2  +4
    // Y  A   H   R
    //
    // 3 - level
    //   +6
    // P  I
    //
    //
    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1) return s;

        int level0 = (numRows - 1) * 2;
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < numRows; row++) {
            sb.append(s.charAt(row));
            int gap = level0 - (2 * row);
            for (int i = row + gap; i < s.length(); i += gap) {
                if (gap != 0) {
                    sb.append(s.charAt(i));
                }
                gap = level0 - gap;
            }
        }
        return sb.toString();
    }
}
