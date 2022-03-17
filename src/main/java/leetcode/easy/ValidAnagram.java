package leetcode.easy;

public class ValidAnagram {

    //
    // dict: []
    //
    // t: O (N)
    // space: O (1)
    //
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null || s.length() != t.length()) return false;

        int[] dict = new int[26];
        for (char ch : s.toCharArray()) {
            int idx = this.charIndex(ch);
            dict[idx]++;
        }
        for (char ch : t.toCharArray()) {
            int idx = this.charIndex(ch);
            dict[idx]--;
            if (dict[idx] < 0) {
                return false;
            }
        }
        return true;
    }

    private int charIndex(char ch) {
        return ch - 'a';
    }

    public static void main(String[] args) {
        System.out.println(new ValidAnagram().isAnagram( "anagram", "nagaram"));
        System.out.println(new ValidAnagram().isAnagram( "anagram", "nagdaram"));
    }
}
