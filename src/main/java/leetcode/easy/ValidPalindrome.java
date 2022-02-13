package leetcode.easy;

public class ValidPalindrome {

    //  i                            j
    // "A man, a plan, a canal: Panama"
    //
    //
    // t: O (N)
    // space: O (1)
    //
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        if (" ".equals(s)) return true;
        int left = 0, right = s.length() - 1;
        while (left < right && left < s.length() - 1 && right >= 0) {
            while (left < right && left < s.length() - 1 && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            char l = s.charAt(left);
            if (left == right) break;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            char r = s.charAt(right);
            if (Character.toLowerCase(l) != Character.toLowerCase(r)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new ValidPalindrome().isPalindrome("0P"));
        System.out.println(new ValidPalindrome().isPalindrome(".,"));
        System.out.println(new ValidPalindrome().isPalindrome("ab_a"));
    }
}
