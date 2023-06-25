package leetcode.数组;

/**
 * @author ysj
 * @date 2023/6/14
 * @desc
 */
public class 区域和检索_303 {

    int[] preSums;

    public 区域和检索_303(int[] nums) {
        preSums = new int[nums.length + 1];
        for (int i = 1; i < preSums.length; i++) {
            preSums[i] = preSums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return preSums[right + 1] - preSums[left];
    }


    public static void main(String[] args) {
        int[] nums= {-2,0,3,-5,2,-1};
        区域和检索_303 test = new 区域和检索_303(nums);
        test.sumRange(0,2);
    }
}
