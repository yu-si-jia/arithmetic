package leetcode.judgeSquareSum_633;

/**
 * @author andor
 * @date 2021/4/28
 * @desc 633. 平方数之和
 */
public class Solution {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }


    public boolean judgeSquareSum1(int c){
        int left = 0;
        int right = (int)Math.sqrt(c);
        while (left<=right){
            int sum = left*left+right*right;
            if (sum == c){
                return true;
            }else if (sum<c){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
