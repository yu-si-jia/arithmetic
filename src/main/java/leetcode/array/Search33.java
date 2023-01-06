package leetcode.array;

/**
 * @author ysj
 * @date 2022/11/29
 * @desc 33. 搜索旋转排序数组
 */
public class Search33 {
    public static int search(int[] nums, int target) {
        int mid = 0;
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            mid = (i + j) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else {
                if (nums[mid] < target && target < nums[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        search(nums,0);
    }
}
