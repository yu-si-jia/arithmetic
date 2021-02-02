package leetcode.massage;

/**
 * @author YuSiJia
 * @date 2020/3/24
 * @desc 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
 * 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 */
public class Test01 {
    public int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        sum[1] = nums[1];
        sum[2] = nums[2] + nums[0];
        for (int i = 3; i < nums.length; i++) {
            sum[i] = nums[i] + Math.max(sum[i - 2], sum[i - 3]);
        }
        return Math.max(sum[nums.length - 1], sum[nums.length - 2]);
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        System.out.println(new Test01().massage(a));
    }
}
