package leetcode.股票;

/**
 * @author HeJiageng
 * @date 2023/12/2
 * @desc
 */
public class 买卖股票的最佳时机4_188 {
    public int maxProfit(int[] prices,int k) {
        int n = prices.length;

        // 代表K没有限制
        if (k > n / 2) {
            return maxProfit(prices);
        } else {
            // k 有限制
            int[][][] dp = new int[n][k + 1][2];

            for (int i = 0; i < n; i++) {
                dp[i][0][1] = Integer.MIN_VALUE;
                dp[i][0][0] = 0;
            }
            for (int i = 0; i < n; i++) {
                for (int m = k; k >= 1; k--) {
                    if (i - 1 == -1) {
                        dp[i][m][0] = 0;
                        dp[i][m][1] = -prices[i];
                        continue;
                    }
                    dp[i][k][0] = Math.max(dp[i - 1][m][0], dp[i - 1][m][1] + prices[i]);
                    dp[i][k][1] = Math.max(dp[i - 1][m - 1][0] - prices[i], dp[i - 1][m][1]);
                }
            }
            return dp[n - 1][k][0];
        }

    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i] );
        }

        return dp[n-1][0];
    }

}
