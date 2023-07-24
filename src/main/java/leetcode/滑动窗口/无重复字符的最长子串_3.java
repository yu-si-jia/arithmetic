package leetcode.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ysj
 * @date 2023/7/19
 * @desc
 */
public class 无重复字符的最长子串_3 {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            window.put(c, window.getOrDefault(c, 0) + 1);
            // 判断左侧窗口是否要收缩
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                window.put(d, window.get(d) - 1);
            }
            // 在这里更新答案
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        无重复字符的最长子串_3.lengthOfLongestSubstring("pwwkew");
    }
}
