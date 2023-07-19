package leetcode.滑动窗口;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ysj
 * @date 2023/7/19
 * @desc
 */
public class 找到字符串中所有字母的异位词_438 {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();

        int left = 0, right = 0, vaild = 0;

        while (right < s.length()) {
            char a = s.charAt(right);
            right++;
            if (need.containsKey(a)) {
                window.put(a, window.getOrDefault(a, 0) + 1);
                if (need.get(a).equals(window.get(a))){
                    vaild++;
                }
            }

            if (right-left>=p.length()){
                if (right-left==p.length() && vaild == need.size()){
                    res.add(left);
                }

                char l = s.charAt(left);
                left++;
                if (window.containsKey(l)){
                    if (need.get(l).equals(window.get(l))){
                        vaild--;
                    }
                    window.put(l, window.getOrDefault(l, 0) - 1);
                }
            }
        }
        return res;
    }
}
