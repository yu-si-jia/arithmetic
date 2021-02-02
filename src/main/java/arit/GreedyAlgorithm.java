package arit;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 贪心算法
 */
public class GreedyAlgorithm {
    /**
     * @param coins 硬币面值数组
     * @param money 要找零总钱数
     */
    void test1(int[] coins,int money){
        for (int i = 0;i<coins.length; i++){
            if (money>=coins[i]){
                int s=(money/coins[i]);
                System.out.println("应该找零："+coins[i]+"分，"+(money/coins[i])+"个");
                money=money-s*coins[i];
            }
        }
    }

    /**
     * 买卖股票的最佳时机，只能持有一股，一天可以买卖无数次，求最大收益
     * @param arr
     * @return
     */
    int gupiao(int[] arr){
        int sum = 0;
        for (int i=0;i+1<arr.length; i++){
            if (arr[i+1]>arr[i]){
                sum += arr[i+1]-arr[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        GreedyAlgorithm greedyAlgorithm = new GreedyAlgorithm();
        int[] arr= {1,2,3,4,5};
        System.out.println(greedyAlgorithm.gupiao(arr));
    }
}
