package arithstudy.arr;

/**
 * @author andor
 * @date 2021/3/23
 * @desc 26. 删除有序数组中的重复项
 *       80. 删除有序数组中的重复项 II
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;
        while (slow+1<nums.length){
            if (nums[slow] != nums[slow + 1]) {
                nums[fast] = nums[slow + 1];
                fast++;
            }
            slow++;
        }
        return nums.length==0?0:fast;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length<2){
            return nums.length;
        }
        int slow = 0;
        int fast = slow;
        int count = 0;
        while (fast<nums.length){

        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,4,5,6};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int i=2;
        System.out.println(i++);
//        removeDuplicates.removeDuplicates(nums);
    }
}
