package leetcode.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ysj
 * @date 2023/7/7
 * @desc
 */
public class 最小覆盖子串_76 {
    public static String minWindow(String s, String t) {

        // 每个字符出现的次数
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            // c 出现的次数
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        // 字符串中已满足
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right);
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            right++;

            // 更新最短
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }


    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        最小覆盖子串_76.minWindow(s, "ABC");
    }
}
