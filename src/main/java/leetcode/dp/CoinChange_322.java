package leetcode.dp;

import java.util.Arrays;

/**
 * @author ysj
 * @date 2023/5/6
 * @desc 322. 零钱兑换
 * dp[i]是指凑i元需要的硬币数， i是指金额
 */
public class CoinChange_322 {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 统一填充为最大值
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        // i 为金额
        for (int i = 1; i <= amount; i++) {
            // coins[j] 是硬币面值
            for (int j = 0; j < coins.length; j++) {
                // 当前硬币面值小于金额才能参与凑钱
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        coinChange(coins, 11);
    }
}
