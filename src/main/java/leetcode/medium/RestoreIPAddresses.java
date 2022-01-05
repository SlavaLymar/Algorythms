package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

    // s        e
    // 2  5  5  2  5  5  1  1  1  3  5
    //
    //
    //
    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        restoreIpAddresses(result, new ArrayList<>(), s, 4, 0);
        return result;
    }

    private void restoreIpAddresses(List<String> result,
                                    List<String> innerResult,
                                    String s,
                                    int parts,
                                    int start) {
        if (parts == 1) {
            if (start <= s.length() - 1 && s.length() - 1 - start <= 3) {
                String substring = s.substring(start);
                if (checkAddr(substring)) {
                    StringBuilder sb = new StringBuilder();
                    for (String str : innerResult) {
                        sb.append(str).append('.');
                    }
                    sb.append(substring);
                    result.add(sb.toString());
                }
            }
        } else {
            int end = start;
            while (end < s.length()
                    && end - start <= 3
                    && checkAddr(s.substring(start, end + 1))) {
                if (((float)(s.length() - 1 - end)) / ((float)(parts - 1)) <= 3.0f) {
                    innerResult.add(s.substring(start, end + 1));
                    restoreIpAddresses(result, innerResult, s, parts - 1, end + 1);
                    if (innerResult.size() > 0) {
                        innerResult.remove(innerResult.size() - 1);
                    }
                }
                end++;
            }
        }
    }

    private boolean checkAddr(String s) {
        if (s.charAt(0) == '0') {
            return s.length() == 1;
        }
        return Integer.parseInt(s) <= 255;
    }

    public static void main(String[] args) {
        System.out.println(new RestoreIPAddresses().restoreIpAddresses("25525511135"));
//        System.out.println(new RestoreIPAddresses().restoreIpAddresses("0000"));
//        System.out.println(new RestoreIPAddresses().restoreIpAddresses("101023"));
    }
}
