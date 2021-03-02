package arithstudy.arr;

/**
 * @author andor
 * @date 2021/3/1
 * @desc 303. 区域和检索 - 数组不可变
 */
public class NumArray {
    private int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length];
        if (nums.length==0){
            return;
        }
        sums[0] = nums[0];
        for (int i=1;i<nums.length;i++){
            sums[i] += nums[i]+nums[i-1];

        }
    }

    public int sumRange(int i, int j) {
        if (i==0) return sums[j];
        return sums[j]-sums[i-1];
    }


}
