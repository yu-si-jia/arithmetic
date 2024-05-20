package leetcode.前缀和;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ysj
 * @date 2024/5/16
 * @desc
 */
public class 和可被K整除的子数组_974 {
    public static int subarraysDivByK(int[] nums, int k) {
        int length = nums.length;
        int result = 0;
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1);
        for (int i = 0; i < length; i++) {
            int remainder = (sum[i + 1] % k + k) % k;
            result += countMap.getOrDefault(remainder, 0);
            countMap.put(remainder, countMap.getOrDefault(remainder, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        int i = 和可被K整除的子数组_974.subarraysDivByK(nums, k);
        System.out.println(i);
    }

}
