package leetcode.滑动窗口;

/**
 * @author ysj
 * @date 2023/8/22
 * @desc
 */
public class 长度最小的子数组_209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0, sum = 0;
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        if (n == 0) {
            return 0;
        }
        while (end < n) {
            sum = sum + nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum = sum - nums[start];
                start++;
            }
            end++;

        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        长度最小的子数组_209.minSubArrayLen(7, nums);
    }


}
