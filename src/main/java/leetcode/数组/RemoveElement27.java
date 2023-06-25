package leetcode.数组;

/**
 * @author andor
 * @date 2021/6/4
 * @desc 27. 移除元素
 */
public class RemoveElement27 {


    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }


}
