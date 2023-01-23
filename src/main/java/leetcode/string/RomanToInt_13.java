package leetcode.string;

/**
 * @author ysj
 * @date 2023/1/23
 * @desc 13 罗马数字转数字 小数放在大数前面做减法，否则做加法
 */
public class RomanToInt_13 {
    public int romanToInt(String s) {
        char first = s.charAt(0);
        int sum = 0;
        int preNum = getValue(first);
        for (int i = 1; i < s.length() - 1; i++) {
            int num = getValue(s.charAt(i));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    public int getValue(char a) {
        switch (a) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
