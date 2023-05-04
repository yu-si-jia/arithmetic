package leetcode.string;

import java.util.Objects;

/**
 * @author ysj
 * @date 2022/1/24
 * @desc 5. 最长回文子串
 */
public class LongestPalindrome_5 {


    public String longestPalindrome(String s) {
        String ans = "";
        int len = s.length();
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String temp = s.substring(i, j);
                if (isPalindrome(temp) && temp.length() > max) {
                    ans = s.substring(i, j);
                    max = Math.max(max, ans.length());
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(String a) {
        int start = 0;
        int end = a.length() - 1;
        while (start < a.length() / 2) {
            if (!Objects.equals(a.charAt(start), a.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
