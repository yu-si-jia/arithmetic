package leetcode.minIncrementForUnique;

import java.util.Arrays;

/**
 * @author YuSiJia
 * @date 2020/3/22
 * @desc 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 *
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 */
public class Test01 {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int move = 0;
        for (int i=1; i<A.length;i++){
            if (A[i]<=A[i-1]){
                int pre = A[i];
                A[i] = A[i-1] +1;
                move += A[i]-pre;
            }
        }
        return move;
    }
}
