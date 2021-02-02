package leetcode.smallerNumbersThanCurrent;

import juc.lockk.reentrantlock.Test;

/**
 * @author andor
 * @date 2020/10/26
 * @desc 1365. 有多少小于当前数字的数字
 */
public class Test01 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        for (int i=0;i<nums.length;i++){
            int count = 0;
            for (int j=0;j<nums.length;j++){
                if (nums[j]<nums[i]){
                    count++;

                }
            }
            result[i] = count;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] arr = {2,4,5,6,7,8,2};
        Test01 test01 = new Test01();
        System.out.println(test01.smallerNumbersThanCurrent(arr));
    }
}
