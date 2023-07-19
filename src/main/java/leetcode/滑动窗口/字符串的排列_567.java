package leetcode.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ysj
 * @date 2023/7/13
 * @desc
 */
public class 字符串的排列_567 {
    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char a : s1.toCharArray()) {
            need.put(a, need.getOrDefault(a, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }


            if (right - left >= s1.length()) {
                if (valid == need.size() && right-left==s1.length()){
                    return true;
                }
                char s = s2.charAt(left);
                left++;
                if (need.containsKey(s)) {
                    if (window.get(s).equals(need.get(s))) {
                        valid--;
                    }
                    window.put(s, window.getOrDefault(s, 0) - 1);
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        字符串的排列_567.checkInclusion(s1,s2);
    }
}
