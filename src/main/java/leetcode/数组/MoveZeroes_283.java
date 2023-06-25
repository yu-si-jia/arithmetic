package leetcode.数组;

/**
 * @author ysj
 * @date 2023/4/19
 * @desc 283: 移动0
 */
public class MoveZeroes_283 {
    public static void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                nums[left] = nums[right];
                left++;
            }
            right ++;
        }

        for (; left< nums.length ; left++){
            nums[left] = 0;
        }
    }


    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
    }
}
