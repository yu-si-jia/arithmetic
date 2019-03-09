package arithstudy;


/**
 * 将任意一个字符串转换为整数
 */
public class StringToInt {
    public double change(String a) {
        char[] str = a.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        double sum = 0;

        if (str[0] > 57 || str[0] < 48) {
            for (int i = 1; i < str.length; i++) {
                if (48 <= str[i] && str[i] <= 57) {
                    stringBuffer = stringBuffer.append(str[i]);
                }
            }
        } else {
            for (int i = 0; i < str.length && 48 <= str[i] && str[i] <= 57; i++) {
                stringBuffer = stringBuffer.append(str[i]);
            }
        }

        String string = stringBuffer.toString();

        for (int i = 0; i < string.length(); i++) {
            sum = sum + Character.getNumericValue(string.charAt(i)) * Math.pow(10, string.length() - i - 1);
        }
        if (str[0] == "-".charAt(0)) {
            sum = sum * -1;
        } else sum = sum * 1;

        return sum;
    }
}
