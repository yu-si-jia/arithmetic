package arit;

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

        if (memo[n] != -1)
            return memo[n];
        //如果已经求出了fib（n）的值直接返回，否则将求出的值保存在Memo备忘录中。
        if (n <= 2)
            memo[n] = 1;

        else memo[n] = fib2(n - 1, memo) + fib2(n - 2, memo);

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

    /*
    动态规划之钢条切割
           给定一段长度为n英寸的钢条和一个价格表pi(i=1,2,…n)，
           求切割钢条方案，使得销售收益rn最大。
           注意，如果长度为n英寸的钢条的价格pn足够大，最优解可能就是完全不需要切割。
        钢条长度i： 1  2  3  4   5   6   7   8   9   10
        钢条价格pi：1  5  8  9   10  17  17  20  24  30
     */

    public int cut1(int[] p, int n) {//n为钢条长度,p为钢条价格数组
        if (n == 0)
            return 0;
        int q = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            q = Math.max(q, p[i - 1] + cut1(p, n - 1));//最优解选择
        }
        return q;
    }

    /**
     * 有一座高度是10级台阶的楼梯，从下往上走，每跨一步只能向上1级或者2级台阶。
     * 要求用程序来求出一共有多少种走法。
     */

    int test1(int n) {
        if (n < 1)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        int a = 1;
        int b = 2;
        int temp = 0;
        for (int i = 0; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }

        return temp;
    }


    /**
     * 有一个国家发现了5座金矿，每座金矿的黄金储量不同，需要参与挖掘的工人数也不同。
     * 参与挖矿工人的总数是10人。每座金矿要么全挖，要么不挖，不能派出一半人挖取一半金矿。
     * 要求用程序求解出，要想得到尽可能多的黄金，应该选择挖取哪几座金矿？
     * 400/5人  500/5 200/3  300/4  350/3
     * @param n 金矿的个数
     * @param w 工人的个数
     * @param g 每个金矿的收益
     * @param p 每个金矿所用人数
     * @return
     */
    int getMostGold(int n, int w, int g[], int p[]) {
        int[] preResult = new int[w+1];
        int[] result = new int[w+1];
        //初始化第一行
        for (int i = 0; i<=w; i++) {
            if (i < p[0])
                preResult[i] = 0;
            else
                preResult[i] = g[0];
        }

        for (int i = 0;i<n;i++){
            for (int j = 0;j<=w; j++){
                if (j<p[i])
                    result[j]=preResult[j];
                else {
                    int a = preResult[j];//不挖i矿
                    int b = preResult[j-p[i]]+g[i];//挖i矿，剩下的人手去挖前面的矿
                    result[j] = Math.max(a,b);
                }
            }
            for(int t = 0;t < preResult.length; t++){
                preResult[t] = result[t];
            }
        }
        return result[w];
    }


    public static void main(String[] args) {
        Fib fib = new Fib();
        int[] g = {400,500,200,300,350};
//        int[] g = {400};
        int[] p = {5,5,3,4,3};
//        int[] p = {5};
        System.out.println(fib.getMostGold(5,10,g,p));

    }
}



