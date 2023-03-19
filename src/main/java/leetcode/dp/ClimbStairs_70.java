package leetcode.dp;

/**
 * @author HeJiageng
 * @date 2023/3/16
 * @desc 70 爬楼梯
 * 爬上第N个台阶的方式是爬上(n-1)+(n-2)个台阶的方式
 */
public class ClimbStairs_70 {
    public int climbStairs(int n) {
        int a = 1;
        int b = 2;
        if (n == 1) {
            return a;
        }
        if (n == 2) {
            return b;
        }
        for (int i = 3; i <= n; i++) {
            int temp = a;
            a = b;
            b = temp + a;
        }
        return b;

    }

}
