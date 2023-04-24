package leetcode.array;

/**
 * @author andor
 * @date 2021/6/3
 * @desc 26. 删除有序数组中的重复项
 */
public class RemoveDuplicates26 {
    public static void main(String[] args) {
        RemoveDuplicates26 removeDuplicates26 = new RemoveDuplicates26();
        int[] a = {1, 2, 2, 3, 4};
        System.out.println(removeDuplicates26.removeDuplicates(a));
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
