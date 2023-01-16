package arithstudy.sort_color_75;

/**
 * @author andor
 * @date 2021/5/10
 * @desc 75. 颜色分类
 */
public class Solution {
    public void sortColors(int[] nums) {
        int ptr = 0;
        for (int i = 0; i< nums.length ;i++){
            if (nums[i]==0){
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ptr++;

            }
        }
        for (int i= ptr; i<nums.length; i++){
            if (nums[i] == 1){
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ptr++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        Solution solution = new Solution();
    }
}