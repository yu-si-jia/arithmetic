package leetcode.数组;

/**
 * @author andor
 * @date 2021/5/25
 * @desc 4. 寻找两个正序数组的中位数
 */
public class FindMedianSortedArrays4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])) {
                right = nums1[aStart++];
            } else {
                right = nums2[bStart++];
            }
        }
        // len是2的倍数
        if ((len & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;

    }

    public static void main(String[] args) {
        System.out.println(4&1);
    }
}
