package leetcode.股票;

/**
 * @author HeJiageng
 * @date 2023/11/26
 * @desc
 */
public class 买卖股票的最佳时机_121 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            if (i-1==-1){
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
