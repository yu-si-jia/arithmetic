package leetcode.滑动窗口;

import java.util.Arrays;

/**
 * @author ysj
 * @date 2023/7/27
 * @desc
 */
public class 将x减到0的最小操作数_1658 {
    public static int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum < x) {
            return -1;
        }
        int right = 0, lsum = 0, rsum = sum, ans = n + 1;
        for (int left = -1; left < n; left++) {
            if (left != -1) {
                lsum =lsum + nums[left];
            }
            while (right < n && lsum + rsum > x) {
                rsum = rsum - nums[right];
                right++;
            }
            if (lsum + rsum == x) {
                ans = Math.min(ans, (left + 1) + (n - right));
            }
        }
        return ans > n ? -1 : ans;
    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 20, 1, 1, 3};
        将x减到0的最小操作数_1658.minOperations(nums, 10);
    }
}
