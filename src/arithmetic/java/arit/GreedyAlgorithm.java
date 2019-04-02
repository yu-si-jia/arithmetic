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
     *
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

    public static void main(String[] args) {
        GreedyAlgorithm greedyAlgorithm = new GreedyAlgorithm();
        int[] coins={5,3,1};
        greedyAlgorithm.test1(coins,7);
    }


}
