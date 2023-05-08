package leetcode.dp;

/**
 * @author ysj
 * @date 2023/5/6
 * @desc 509. 斐波那契数
 */
public class Fib_509 {
    public int fib1(int n) {
        if (n ==0 ){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 1;
        }
        return fib1(n-1)+ fib1(n-2);
    }

    public int fib(int n) {
        if (n<2){
            return 1;
        }
        int[] dp = new int[n];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i<=n ;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
