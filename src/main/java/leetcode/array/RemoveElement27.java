package leetcode.array;

/**
 * @author andor
 * @date 2021/6/4
 * @desc 27. 移除元素
 */
public class RemoveElement27 {
    public int removeElement1(int[] nums, int val) {
        int right = nums.length-1;
        for (int i = 0; i<nums.length; i++){
            if (nums[i] == val){
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                right--;
            }
        }
        return right;
    }


    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }


}
