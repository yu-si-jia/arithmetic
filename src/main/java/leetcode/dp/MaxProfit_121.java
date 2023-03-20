package leetcode.dp;

/**
 * @author HeJiageng
 * @date 2023/3/17
 * @desc 121. 买卖股票的最佳时机
 * 动态规划 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
 */
public class MaxProfit_121 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        // 当前的售价
        int min = prices[0];
        // 最大价格
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(prices[i] - min,max );
            min = Math.min(prices[i], min);
        }
        return max;
    }
}
