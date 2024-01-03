package leetcode.动态规划_回溯;

/**
 * @author HeJiageng
 * @date 2023/12/28
 * @desc
 */
public class 跳跃游戏_45 {
    public static int jump(int[] nums) {
        int step = 0;
        int len = nums.length;
        int maxPosition = 0;
        int end = 0;
        for (int i = 0; i< len-1; i++){
            maxPosition = Math.max(maxPosition, i+ nums[i]);
            if (i == end){
                end = maxPosition;
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[] test = {2,3,1,1,4};
        System.out.println(跳跃游戏_45.jump(test));

    }
}
