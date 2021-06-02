package leetcode.array;

import java.util.Arrays;

/**
 * @author andor
 * @date 2021/6/1
 * @desc 16. 最接近的三数之和
 */
public class ThreeSumClosest16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                }else {
                    return ans;
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        ThreeSumClosest16 threeSumClosest16 = new ThreeSumClosest16();
        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest16.threeSumClosest(nums, 1));

    }
}
