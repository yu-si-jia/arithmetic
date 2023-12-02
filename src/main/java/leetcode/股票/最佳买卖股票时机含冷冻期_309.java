package leetcode.股票;

/**
 * @author HeJiageng
 * @date 2023/12/1
 * @desc
 */
public class 最佳买卖股票时机含冷冻期_309 {
    public static int maxProfitWithCool(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            // 冷冻期是一天 所以此边界case处理冷冻期
            if (i - 2 == -1) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return dp[n-1][0];
    }

    public static void main(String[] args) {
        int[] test = {1,2,3,0,2};
        最佳买卖股票时机含冷冻期_309.maxProfitWithCool(test);
    }
}
