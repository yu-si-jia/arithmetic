package arithstudy.arr;

/**
 * @author andor
 * @date 2021/3/3
 * @desc 338. 比特位计数
 */
public class CountBits {
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        for (int i=0;i<=num;i++){
            result[i] = getBits(i);
        }
        return result;
    }

    private int getBits(int num){
        int count=0;
        while(num!=0){
            int mod=num%2;
            if (mod==1)
                count++;
            num/=2;
        }
        return count;
    }

    public int[] countBits1(int num) {
        int[] bits = new int[num + 1];
        int highBit = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }



    public static void main(String[] args) {
        CountBits countBits = new CountBits();
        countBits.countBits(2);
    }
}
