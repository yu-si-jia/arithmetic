package leetcode.滑动窗口;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ysj
 * @date 2023/8/23
 * @desc
 */
public class 存在重复元素_219 {
    public static boolean containsNearbyDuplicate1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            }
            map.put(num, i);
        }
        return false;
    }


    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                window.remove(nums[i-k-1]);
            }
            if (!window.add(nums[i])){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(存在重复元素_219.containsNearbyDuplicate(nums, 3));
    }
}
