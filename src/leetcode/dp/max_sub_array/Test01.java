package leetcode.dp.max_sub_array;

/**
 * @author YuSiJia
 * @date 2020/3/27
 * @desc 53， 面试题16，17
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 解法1：分治算法
 */
public class Test01 {
    public int maxSubArray(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    public int helper(int[] nums, int left, int right){
        if (left==right) {
            return nums[left];
        }
        int p = (left+right)/2;
        int leftSum = helper(nums,left,p);
        int rightSum = helper(nums, p+1, right);
        int crossSum = crossSum(nums,left,right,p);
        return Math.max(Math.max(leftSum,rightSum),crossSum);
    }

    public int crossSum(int[] nums, int left, int right, int p){
        if (left==right){
            return nums[left];
        }
        int leftSubSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = p; i> left-1; --i ){
            currSum += nums[i];
            leftSubSum = Math.max(leftSubSum,currSum);
        }

        int rightSubSum = Integer.MIN_VALUE;
        currSum = 0;
        for (int i = p+1; i <right + 1; ++i) {
            currSum += nums[i];
            rightSubSum = Math.max(rightSubSum,currSum);
        }
        return rightSubSum+leftSubSum;
    }
}
