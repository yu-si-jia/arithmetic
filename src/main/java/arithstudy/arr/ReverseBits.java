package arithstudy.arr;

/**
 * @author andor
 * @date 2021/3/29
 * @desc 190. 颠倒二进制位
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }
    
}
