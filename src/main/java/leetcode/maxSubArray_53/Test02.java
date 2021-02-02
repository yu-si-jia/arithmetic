package leetcode.maxSubArray_53;

/**
 * @author YuSiJia
 * @date 2020/3/27
 * @desc 动态规划做法
 */
public class Test02 {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num: nums){
            if (sum>0){
                sum += num;
            }else{
                sum = num;
            }
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}
