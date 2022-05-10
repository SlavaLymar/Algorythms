package leetcode.medium;

public class LongestSubstringWithAtLeastKRepeatingCharacters {

    class CharIndexes {
        int start;
        int end;
        int count;
        CharIndexes(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
        }
    }

    //  i
    //  a c d d c b e  k = 2
    //
    // t: O (N ^ 2)
    // space: O (N)
    //
    public int longestSubstring(String s, int k) {
        return longestSubstringUtil(s, 0, s.length(), k);
    }

    int longestSubstringUtil(String s, int start, int end, int k) {
        if (end < k) return 0;
        int[] countMap = new int[26];
        // update the countMap with the count of each character
        for (int i = start; i < end; i++)
            countMap[s.charAt(i) - 'a']++;
        for (int mid = start; mid < end; mid++) {
            if (countMap[s.charAt(mid) - 'a'] >= k) continue;
            int midNext = mid + 1;
            while (midNext < end && countMap[s.charAt(midNext) - 'a'] < k) midNext++;
            return Math.max(longestSubstringUtil(s, start, mid, k),
                    longestSubstringUtil(s, midNext, end, k));
        }
        return (end - start);
    }

    public static void main(String[] args) {
        System.out.println(
                new LongestSubstringWithAtLeastKRepeatingCharacters().longestSubstring("ababacb", 3)
        );
        System.out.println(
                new LongestSubstringWithAtLeastKRepeatingCharacters().longestSubstring("aaabbb", 3)
        );
        System.out.println(
                new LongestSubstringWithAtLeastKRepeatingCharacters().longestSubstring("acddcbe", 2)
        );
    }
}
