package arit;

import java.util.HashMap;
import java.util.Map;

public class Binary {
//二进制问题
}

/**
 * 10-17.18
 * 求一个二进制数有多少个一
 */
class FindOne{
    int countBit(int num){
        int count = 0;
        while(num != 0){
            num = num & (num-1);
            count++;
        }
        return count;
    }
}

/**
 * 10-19.20
 * 快速判断一个数是不是2的x次幂
 */
class WhetherTwo{
    public boolean whether(int num){
        int result = num & (num-1);
        if (result ==0 ){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        WhetherTwo whetherTwo = new WhetherTwo();
        System.out.println(whetherTwo.whether(4));
    }
}
