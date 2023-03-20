package leetcode.common;

/**
 * @author HeJiageng
 * @date 2023/3/20
 * @desc 136. 只出现一次的数字
 */
public class SingleNumber_136 {
    public int singleNumber(int[] nums) {
        int n = nums[0];
        for (int i = 1 ; i<nums.length ; i++){
            n = n ^ nums[i];
        }
        return n;
    }

}
