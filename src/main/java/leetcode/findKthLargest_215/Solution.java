package leetcode.findKthLargest_215;

import java.util.Random;

/**
 * @author andor
 * @date 2021/5/11
 * @desc
 */
public class Solution {
    Random random = new Random();
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);

    }

    /**
     *
     * @param a
     * @param l
     * @param r
     * @param index 从小到大第index位置的元素是第K大的数
     * @return
     */
    private int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    private int randomPartition(int[] nums, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        //找到基准值，按基准值分开排序
        swap(nums, i, r);
        return partition(nums, l, r);
    }
    //负责将数据按轴值一分为二，返回轴值下标，把轴值放在数组的最右边
    private int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,2,1,5,6,4};
        solution.findKthLargest(nums,2);
    }

}
