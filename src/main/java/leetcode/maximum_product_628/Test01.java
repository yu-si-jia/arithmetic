package leetcode.maximum_product_628;

import sun.security.util.ArrayUtil;

import java.util.Arrays;

/**
 * @author andor
 * @date 2021/1/20
 * @desc
 */
public class Test01 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        int d = nums[nums.length-3];
        int e = nums[nums.length-2];
        int f = nums[nums.length-1];
        return Math.max(f*e*d,a*b*f);

    }
}
