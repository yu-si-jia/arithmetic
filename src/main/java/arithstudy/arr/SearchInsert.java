package arithstudy.arr;

/**
 * @author andor
 * @date 2021/1/21
 * @desc 35. 搜索插入位置
 */
public class SearchInsert {
    public int searchInsert01(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n-1;
        while (left<=right){
            int middle = left+(right-left)/2;
            if (nums[middle]>target){
                right=middle-1;
            }else if (nums[middle]<target){
                left = middle+1;
            }else {
                return middle;
            }
        }
        return right+1;
    }

}
