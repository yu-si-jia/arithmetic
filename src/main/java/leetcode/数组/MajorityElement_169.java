package leetcode.数组;

/**
 * @author ysj
 * @date 2023/3/21
 * @desc 169:出现最多的数字
 */
public class MajorityElement_169 {
    public int majorityElement(int[] nums) {
        int num = nums[0];
        int count = 1;
        for (int i = 1; i< nums.length ; i++){
            if (nums[i] == num){
                count++;
            }else {
                count--;
            }

            if (count==0){
                num = nums[i];
                count++;
            }
        }
        return num;
    }

}
