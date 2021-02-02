package arithstudy.arr;

/**
 * @author andor
 * @date 2021/1/25
 * @desc 27. 移除元素
 */
public class RemoveElement {

    public int removeElement1(int[] nums, int val) {
        int slow = 0, fast = 0;
        for (; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right-1];
                right--;
            }else {
                left++;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int[] nums={3,2,2,3};
        System.out.println(removeElement.removeElement(nums,3));
    }

}
