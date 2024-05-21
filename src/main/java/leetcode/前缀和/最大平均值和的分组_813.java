package leetcode.前缀和;

/**
 * @author ysj
 * @date 2024/5/20
 * @desc nums数组最多被分成K组
 */
public class 最大平均值和的分组_813 {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[] prefix = new double[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        double[][] dp = new double[n + 1][k + 1];
        // dp[i][j] 表示[0, i-1] 被切分成j组的最大平均数
        for (int i = 1; i <= n; i++) {
            dp[i][1] = prefix[i] / i;
        }
        for (int j = 2; j <= k; j++) {
            for (int i = j; i <= n; i++) {
                // 动态转移方程：j组 和 j-1组+当前遍历剩下的组的平均值
                for (int x = j - 1; x < i; x++) {
                    dp[i][j] = Math.max(dp[i][j], dp[x][j - 1] + (prefix[i] - prefix[x]) / (i - x));
                }
            }
        }
        return dp[n][k];
    }
}
