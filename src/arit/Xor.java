package arit;

/**
 * @author YuSiJia
 * @date 2020/1/20
 * @desc 异或算法，两个相同异或为0  多适用于找不同
 */
public class Xor {
    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，
     * 其余每个元素均出现两次。找出那个只出现了一次的元素。
     */
    public static int getOnce(int[] arr){
        int result = arr[0];
        for(int i=1 ;i<arr.length; i++){
            int a = arr[i];
            result = result ^ a;
        }
        return result;
    }


    /**
     * 10-19.20
     * 快速判断一个数是不是2的x次幂
     */

    public boolean whether(int num) {
        int result = num & (num - 1);
        if (result == 0) {
            return true;
        }
        return false;
    }

    /**
     * 10-17.18
     * 求一个二进制数有多少个一
     */
    int countBit(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }


}
