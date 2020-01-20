package arit;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 动态规划算法练习题
 * 求斐波拉契数列Fibonacci
 * Fibonacci (n) = 1;   n = 0
 * Fibonacci (n) = 1;   n = 1
 * Fibonacci (n) = Fibonacci(n-1) + Fibonacci(n-2)
 */
public class Fib {

    //正常的递归算法
    public int fib(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }


    //动态规划算法
    public int fibonacci(int n) {
        if (n <= 0)
            return n;
        int memo[] = new int[n + 1];
        for (int i = 0; i <= n; i++)
            memo[i] = -1;
        return fib2(n, memo);
    }

    public int fib2(int n, int[] memo) {
//递归
        if (memo[n] != -1)
            return memo[n];
        //如果已经求出了fib（n）的值直接返回，否则将求出的值保存在Memo备忘录中。
        if (n <= 2)
            memo[n] = 1;

        else memo[n] = fib2(n - 1, memo) + fib2(n - 2, memo);//最后一步1+最后一步2

        return memo[n];
    }


    public int fib3(int n) {
        if (n <= 0)
            return n;
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }


    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if(target ==0){
            return 0;
        }
        if (target == 1){
            return 1;
        }
        if (target == 2){
            return 2;
        }
        return JumpFloor(target-1)+JumpFloor(target-2);
    }


    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        int[] targets = new int[target];
        return JumpFloorII1(target,targets);
    }

    public int JumpFloorII1(int target,int[] targets) {
        Arrays.fill(targets,0);
        if (targets[target] != -1)
            return targets[target];
        //如果已经求出了fib（n）的值直接返回，否则将求出的值保存在Memo备忘录中。
        if (target <= 2)
            targets[target] = 1;

        else targets[target] = JumpFloorII1(target - 1, targets) + JumpFloorII1(target - 2, targets)+1;//最后一步1+最后一步2

        return targets[target];
    }

    public int JumpFloorII2(int target){
        if (target == 0){
            return 0;
        }

        int[] dp = new int[target+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2;i<target; i++){
            dp[i] = 0;
            for (int j = 0; j<i;j++){
                dp[i] += dp[j];
            }
        }
        return dp[target];
    }


    /**
    动态规划之钢条切割
           给定一段长度为n英寸的钢条和一个价格表pi(i=1,2,…n)，
           求切割钢条方案，使得销售收益rn最大。
           注意，如果长度为n英寸的钢条的价格pn足够大，最优解可能就是完全不需要切割。
        钢条长度i： 1  2  3  4   5   6   7   8   9   10
        钢条价格pi：1  5  8  9   10  17  17  20  24  30
     */

    public int cut1(int[] p, int n) {//n为钢条长度,p为钢条价格数组
        int[] result = new int[n + 1];
        Arrays.fill(result,1);
        for (int i = 0; i < n; i++) {
            for (int j = 1;j<=i;j++){
                result[i] = Math.max(p[i],p[i-1]+1);
            }
        }
        return result[n-1];
    }


    /**
     * 有一个国家发现了5座金矿，每座金矿的黄金储量不同，需要参与挖掘的工人数也不同。
     * 参与挖矿工人的总数是10人。每座金矿要么全挖，要么不挖，不能派出一半人挖取一半金矿。
     * 要求用程序求解出，要想得到尽可能多的黄金，应该选择挖取哪几座金矿？
     * 400/5人  500/5 200/3  300/4  350/3
     *
     * @param n 金矿的个数
     * @param w 工人的个数
     * @param g 每个金矿的收益
     * @param p 每个金矿所用人数
     * @return
     */
    int getMostGold(int n, int w, int g[], int p[]) {
        int[] preResult = new int[w + 1];
        int[] result = new int[w + 1];
        preResult[0] = result[0] = 0;
        //初始化第一行
        for (int i = 0; i <= w; i++) {
            if (i < p[0])
                preResult[i] = 0;
            else
                preResult[i] = g[0];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (j < p[i])
                    result[j] = preResult[j];
                else {
                    int a = preResult[j];//不挖i矿
                    int b = preResult[j - p[i]] + g[i];//挖i矿，剩下的人手去挖前面的矿
                    result[j] = Math.max(a, b);
                }
            }
            for (int t = 0; t < preResult.length; t++) {
                preResult[t] = result[t];
            }
        }
        return result[w];
    }


    /**
     * 假设有几种硬币，如1、3、5，并且数量无限。请找出能够组成某个数目的找零所使用最少的硬币数。
     *
     * @param money 总钱数
     * @param coins 硬币的面值
     */
    int test2(int[] coins, int money) {
        int[] result = new int[money + 1];
        Arrays.fill(result, money + 1);
        result[0] = 0;
        for (int i = 0; i <= money; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    int a = result[i];
                    int b = result[i - coins[j]] + 1;//这个1加的应该是个数
                    result[i] = Math.min(a, b);
//                    System.out.println(a+" vs "+b+ "-----result[i]:------"+i+"   "+result[i]);

                }
            }
        }
        return result[money] > money ? -1 : result[money];
    }

    /**
     * 输入m*n阶数组，计算出发点到结束点的最短距离
     * @param m
     * @param n
     *
     */
    void getMinDistince(int m,int n){
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    if (j == 0) {
                        dp[i][j] = arr[i][j];
                    } else {
                        dp[i][j] = dp[i][j - 1] + arr[i][j];
                    }
                } else {
                    if (j == 0) {
                        dp[i][j] = dp[i - 1][j] + arr[i][j];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
                    }
                }
            }
        }
        System.out.println(dp[m - 1][n - 1]);
    }

    public static void main(String[] args) {
        Fib fib = new Fib();
        fib.getMinDistince(3,3);
    }

    /**
     * Q去打怪兽，也可以花钱雇佣怪兽，
     * 例如：3
     * 8 5 10
     * 1 1 2
     * 代表会遇见三个怪兽 武力值分别是8 5 10 雇佣钱数是 1 1 2 武力值不会消耗
     * 要安全通过雇佣一号和二号怪兽就好 花费2金币
     *
     * @param n      怪兽数量
     * @param attack 怪兽武力值
     * @param price  怪兽价格
     */
    public static void tencent(int n, int[] attack, int[] price) {
        int maxSumP = 0;
        int maxA = 0;
        for (int i = 0; i < n; i++) {
            maxSumP += price[i];
            if (maxA < attack[i]) {
                maxA = attack[i];
            }
        }
        int[][] p = new int[n + 1][maxSumP + 1];
        for (int i = 1; i <= maxSumP; i++) {
            p[1][i] = attack[0];
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= maxSumP; j++) {
                if (j > price[i - 1]) {//当前拥有的钱数够雇佣当前怪
                    p[i][j] = p[i - 1][j - price[i - 1]] + attack[i - 1];
                    //当前拥有的钱数-雇佣当前怪的钱数剩下的钱数在打前一个怪时有的武力值+当前怪武力值
                } else {
                    p[i][j] = p[i - 1][j];//在有j钱数时打i-1怪的武力值
                }
            }
        }
        for (int i = 1; i < maxSumP; i++) {
            if (p[n][i] >= maxA) {
                System.out.println(i);
                break;
            }
        }
    }

}







