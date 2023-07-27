package leetcode.滑动窗口;

import java.util.TreeMap;

/**
 * @author ysj
 * @date 2023/7/25
 * @desc treeMap
 */
public class 绝对差不超过限制的最长连续子数组_1438 {
    public static int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < nums.length) {
            m.put(nums[right], m.getOrDefault(nums[right], 0) + 1);
            while (m.lastKey() - m.firstKey() > limit) {
                m.put(nums[left], m.get(nums[left]) - 1);
                if (m.get(nums[left]) == 0) {
                    m.remove(nums[left]);
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {8, 2, 4, 7};
        绝对差不超过限制的最长连续子数组_1438.longestSubarray(nums, 4);
    }
}
