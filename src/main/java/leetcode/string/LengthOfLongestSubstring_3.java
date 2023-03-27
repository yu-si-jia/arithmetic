package leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ysj
 * @date 2022/1/12
 * @desc 3. 无重复字符的最长子串
 */
public class LengthOfLongestSubstring_3 {
    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < len; end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(map.get(c), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }



    public static void main(String[] args) {
        LengthOfLongestSubstring_3.lengthOfLongestSubstring("pwdeewd");
    }
}
