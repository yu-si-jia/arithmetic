package leetcode.remove_duplicates_80;

/**
 * @author andor
 * @date 2021/5/8
 * @desc 80 删除排序数组中的重复项 II
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int slow = 2;
        int fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}
