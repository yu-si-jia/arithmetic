package leetcode.string;

import java.util.Objects;

/**
 * @author ysj
 * @date 2022/1/24
 * @desc 5. 最长回文子串
 */
public class LongestPalindrome_5 {

    public String longestPalindrome1(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }




    public String longestPalindrome(String s) {
        String ans = "";
        int len = s.length();
        int max = 0;
        for (int i = 0; i<len;i++){
            for (int j = i+1; j <=len ; j++) {
                String temp = s.substring(i,j);
                if (isPalindrome(temp)&&temp.length()>max){
                    ans = s.substring(i,j);
                    max = Math.max(max,ans.length());
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(String a){
        int start = 0;
        int end = a.length()-1;
        while (start<a.length()/2){
            if (!Objects.equals(a.charAt(start),a.charAt(end))){
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }
}
