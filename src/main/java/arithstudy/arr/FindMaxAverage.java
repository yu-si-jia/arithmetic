package arithstudy.arr;

/**
 * @author andor
 * @date 2021/2/21
 * @desc 643. 子数组最大平均数 I
 */
public class FindMaxAverage {
    public double findMaxAverage(int[] nums, int k) {
        if (k > nums.length || nums.length == 0) {
            return 0.0;
        }
        double maxsum = 0;
        double sum = 0;
        //第一个窗口的和
        for (int i = 0; i < k; ++i) {
            sum += nums[i];
        }
        //保存
        maxsum = sum;
        //求出最大和
        for (int j = k; j < nums.length; ++j) {
            sum = sum + nums[j] - nums[j-k];
            maxsum = Math.max(maxsum,sum);
        }
        //返回
        return maxsum / k;
    }
}
