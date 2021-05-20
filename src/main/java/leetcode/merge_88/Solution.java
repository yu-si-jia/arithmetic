package leetcode.merge_88;

/**
 * @author andor
 * @date 2021/5/14
 * @desc 88合并两个有序数组
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] sorted = new int[m+n];
        int p1 = 0;
        int p2 = 0;
        int cur = 0;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 ={1,2,3};
        int[] nums2 = {2,5,6};
        solution.merge(nums1,3,nums2,3);
    }
}
