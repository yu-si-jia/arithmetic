package leetcode.array;

/**
 * @author andor
 * @date 2021/5/20
 * @desc 11. 盛最多水的容器
 */
public class MaxArea11 {
    public int maxArea(int[] height) {
        int left = 0;

        int right = height.length-1;

        int result = 0;

        while (left<right){
            int area = Math.min(height[left], height[right]) * (right - left);
            result = Math.max(area,result);
            if (height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        MaxArea11 maxArea11 = new MaxArea11();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea11.maxArea(height));
    }

}
