package leetcode.动态规划_回溯;

/**
 * @author ysj
 * @date 2024/6/11
 * @desc
 */
public class 最大子数组和_53 {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        int[] dp = new int[n];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        最大子数组和_53.maxSubArray(nums);
    }
}
