package leetcode.数组;

/**
 * @author andor
 * @date 2021/5/21
 * @desc 209. 长度最小的子数组
 */
public class MinSubArrayLen209 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n==0){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;

    }


    public static void main(String[] args) {
        MinSubArrayLen209 minSubArrayLen209 = new MinSubArrayLen209();
        minSubArrayLen209.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
    }
}
