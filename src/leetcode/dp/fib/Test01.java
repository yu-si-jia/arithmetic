package leetcode.dp.fib;

/**
 * @author YuSiJia
 * @date 2020/4/2
 * @desc
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
 * 实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 *
 */
public class Test01 {
    final static int mod = 1000000007;
    public int waysToStep(int n) {
        if ( n== 1){
            return 1;
        }
        if ( n== 2){
            return 2;
        }
        if ( n== 3){
            return 4;
        }
        int[] result = new int[n];
        result[0] = 1;
        result[1] = 2;
        result[2] = 4;
        for (int i = 3; i< n; i++){
            result[i] = ((result[i-3]%mod + result[i-2]%mod)%mod + result[i-1]%mod)%mod;
        }
        return result[n-1];
    }
}
