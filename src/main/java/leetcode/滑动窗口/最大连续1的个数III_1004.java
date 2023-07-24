package leetcode.滑动窗口;

/**
 * @author ysj
 * @date 2023/7/24
 * @desc
 */
public class 最大连续1的个数III_1004 {
    public static int longestOnes(int[] nums, int k) {
        int ans = 0;
        int left = 0, right = 0;
        int countZero = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                countZero++;
            }
            while (countZero > k) {
                if (nums[left] == 0) {
                    countZero--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        最大连续1的个数III_1004.longestOnes(nums, 3);
    }
}
