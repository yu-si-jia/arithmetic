package leetcode.数组;

/**
 * @author ysj
 * @date 2023/1/9
 * @desc 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class SearchRange34 {


    public int[] searchRange(int[] nums, int target) {
        int l = search(nums, target);
        int r = search(nums, target + 1);
        if (l == nums.length || nums[l] != target)
            return new int[]{-1, -1};
        return new int[]{l, r - 1};
    }

    //找>=target的第一个
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (r + l) >> 1;
            if (nums[mid] >= target)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }



    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
//        SearchRange34.mySearchRange(nums, 8);
    }
}
