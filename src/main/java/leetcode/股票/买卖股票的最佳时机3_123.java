package leetcode.股票;

/**
 * @author HeJiageng
 * @date 2023/12/2
 * @desc
 */
public class 买卖股票的最佳时机3_123 {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int maxK = 2;

        int[][][] dp = new int[n][maxK + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = maxK; k >= 1; k--) {
                if (i - 1 == -1) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k - 1][0] - prices[i], dp[i-1][k][1]);
            }
        }
        return dp[n-1][maxK][0];
    }

    public static void main(String[] args) {
        int[] test = {3,3,5,0,0,3,1,4};
        买卖股票的最佳时机3_123.maxProfit(test);
    }
}
