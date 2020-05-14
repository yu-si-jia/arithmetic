package leetcode.trap;

/**
 * @author YuSiJia
 * @date 2020/4/4
 * @desc LeetCode 42接雨水
 */
public class Test01 {
    public int trap(int[] height) {
        int left = 0;
        int leftMax = 0;
        int right = height.length - 1;
        int rightMax = 0;
        int ans = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    ans += leftMax - height[left];
                }
                left++;
            }else {
                if (height[right]>=rightMax){
                    rightMax = height[right];
                }else {
                    ans += rightMax - height[right];
                }
                right--;
            }
        }
        return ans;

    }


    public int trap1(int[] height) {
        int l=0;
        int r=height.length-1;
        int max_l=0;
        int max_r=0;
        int res=0;
        while(l<=r){
            if(max_l<max_r){
                if(height[l]<max_l) res+=max_l-height[l];
                else max_l=height[l];
                l++;
            }else {
                if(height[r]<max_r) res+=max_r-height[r];
                else max_r=height[r];
                r--;
            }
        }
        return res;
    }

}
