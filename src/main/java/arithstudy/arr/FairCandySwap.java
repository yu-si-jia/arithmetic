package arithstudy.arr;

import java.util.Arrays;

/**
 * @author andor
 * @date 2021/2/19
 * @desc 888. 公平的糖果棒交换
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 *
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 *
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 *
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。

 */
public class FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sunA = Arrays.stream(A).sum();
        int sunB = Arrays.stream(B).sum();
        int diff = (sunA-sunB)/2;
        int[] ans = new int[2];
        int left = 0;
        int right = 0;
        Arrays.sort(A);Arrays.sort(B);
        while (left<A.length&&right<B.length){
            if (A[left]-B[right]==diff){
                ans[0] = A[left];
                ans[1] = B[right];
                return ans;
            }
            if (A[left]-B[right]<diff){
                ++left;
            }
            if (A[left]-B[right]>diff){
               ++right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {2};
        int[] B = {1,3};
        FairCandySwap fairCandySwap = new FairCandySwap();
        fairCandySwap.fairCandySwap(A,B);
    }
}
