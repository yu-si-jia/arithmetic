package leetcode.动态规划;

import java.util.Arrays;

/**
 * @author HeJiageng
 * @date 2023/12/4
 * @ dp[i] 表示 以nums[i]结尾的 最长递增序列的长度
 */
public class 最长递增子序列_300 {
    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // 满足判断条件，则可以将num[i]追加到后面成为递增，则取值是dp[j]+1
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int i = 0 ; i < dp.length; i++){
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}
