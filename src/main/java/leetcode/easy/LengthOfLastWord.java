package leetcode.easy;

public class LengthOfLastWord {

    //
    // "   fly me   to   the moon  "
    //                      s   e
    //
    // t: O (N)
    // space: O (1)
    //
    public static int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }
}
