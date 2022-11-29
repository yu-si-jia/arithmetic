package leetcode.array;

/**
 * @author ysj
 * @date 2022/5/5 31. 下一个排列
 * @desc 解题思路：
 * 1. 一个数组，下一个最大的，要让右边一个较小的数，与左边一个较大的数交换
 * 交换的两个元素，距离越近越好，也就是较小的数尽量靠右，最大的数尽量小
 */
public class NextPermutation_31 {
    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // 以 4 5 2 6 3 1 为例， i=2 指向了2 找右边一个尽量小的数
        if (i >= 0) {
            // 找左边一个尽量大的数, j = 4
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            // 找右边一个
            sawp(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private static void sawp(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            sawp(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 6, 3, 1};
        nextPermutation(nums);
    }
}
