package leetcode.动态规划_回溯;

import java.util.Arrays;

/**
 * @author HeJiageng
 * @date 2023/12/4
 * @desc
 */
public class 零钱兑换_322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }

        return dp[amount]> amount ? -1 : dp[amount];
    }
}
