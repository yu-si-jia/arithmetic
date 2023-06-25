package leetcode.数组;

/**
 * @author andor
 * @date 2021/6/3
 * @desc 26. 删除有序数组中的重复项
 */
public class 删除有序数组中的重复项_26 {
    public static void main(String[] args) {
        删除有序数组中的重复项_26 删除有序数组中的重复项26 = new 删除有序数组中的重复项_26();
        int[] a = {1, 2, 2, 3, 4};
        System.out.println(删除有序数组中的重复项26.removeDuplicates(a));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int first = 0;
        int second = 1;
        while (second < nums.length) {
            if (nums[first] != nums[second]){
                nums[first+1] = nums[second];
                first++;
            }
            second++;
        }
        return first+1;
    }
}
