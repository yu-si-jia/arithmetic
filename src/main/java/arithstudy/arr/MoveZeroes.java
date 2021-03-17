package arithstudy.arr;

/**
 * @author andor
 * @date 2021/3/8
 * @desc 283. 移动零
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int result = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i]==0){
                result++;
            }
            else if (result!=0){
                nums[i-result] = nums[i];
                nums[i] = 0;
            }
        }
    }

}
