package arithstudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExeTwo {
    /**
     * 获取两个字符串的最大相同子串
     *
     * @param str1
     * @param str2
     * @return
     */
    public static List<String> getMaxSubString1(String str1, String str2) {
        String str;
        List<String> list = new ArrayList<String>();
        String maxStr = (str1.length() > str2.length()) ? str1 : str2;
        String minStr = (str1.length() < str2.length()) ? str1 : str2;
//			System.out.println("max的长度" + maxStr.length());
//			System.out.println("min的长度" + minStr.length());
        /*
         * 因为取的是最长子串，每一轮外层循环结束后就要把被匹配的长度-1(即i),i 是逐级递加的
         */
        for (int i = minStr.length(); i > 0; i--) {
            for (int j = 0; j + i <= minStr.length(); j++) {//j是初始位置，j+i是要取得的子串长度，不能超过最短的那个串
                str = minStr.substring(j, j + i);  //取的是j+1,j+i位置的子串，j是索引，取后面的一位
                int x = j + i;                    //i 是要取的子串的长度
                System.out.println("i=" + i + "   " + "j=" + j + "   " + x + "   " + str);
                if (maxStr.contains(str)) {
                    list.add(str);
                }
            }
            if (!list.isEmpty())//判断集合是否是空的
                return list;//如果没有此判断条件，所有循环取出来的字符都会添加到集合里
        }
        return list;
    }

    /**
     * 找两个字符串的相同串
     */
    public static List<String> getString(String str1, String str2, int minLength) {
        //minLength是指要取得的子串的最小，就是要求多少个字母相同才算相同
        List<String> list = new ArrayList<String>();
        String maxStr = (str1.length() > str2.length()) ? str1 : str2;
        String minStr = (str1.length() < str2.length()) ? str1 : str2;
        for (int i = 0; i + minLength <= minStr.length(); i++) {
            String subString = null;
            for (int j = minLength; j + i <= minStr.length(); j++) {
                if (maxStr.contains(minStr.substring(i, i + j))) {
                    subString = minStr.substring(i, i + j);
                    int x = i + j;
                    System.out.println("i=" + i + "   j=" + j + "   i+j=" + x + "    " + subString);
                } else {
                    break;
                }
            }
            if (!"".equals(subString)) {
                list.add(subString);
                i = i + subString.length() - 1;//i是开始取子串的位置，上一次取的地方加上这次取得的长度-1防止重复取
            }
        }
        return list;
    }

    /**
     * 小易准备去魔法王国采购魔法神器,购买魔法神器需要使用魔法币,但是小易现在一枚魔法币都没有,
     * 但是小易有两台魔法机器可以通过投入x(x可以为0)个魔法币产生更多的魔法币。
     * 魔法机器1:如果投入x个魔法币,魔法机器会将其变为2x+1个魔法币
     * 魔法机器2:如果投入x个魔法币,魔法机器会将其变为2x+2个魔法币
     * 小易采购魔法神器总共需要n个魔法币,所以小易只能通过两台魔法机器产生恰好n个魔法币,
     * 小易需要你帮他设计一个投入方案使他最后恰好拥有n个魔法币。
     * 输入描述:
     * 输入包括一行,包括一个正整数n(1 ≤ n ≤ 10^9),表示小易需要的魔法币数量。
     * 输出描述:
     * 输出一个字符串,每个字符表示该次小易选取投入的魔法机器。其中只包含字符'1'和'2'。
     * 输入例子1:
     * 10
     * 输出例子1:
     * 122
     */
    public void getMoney(int nmoney) {
        int sum = 0;
        StringBuffer str = new StringBuffer();
        while (sum != nmoney) {
            if (nmoney % 2 != 0) {
                str = str.append("1");
                nmoney = (nmoney - 1) / 2;
            } else {
                str = str.append("2");
                nmoney = (nmoney - 2) / 2;
            }
        }
        System.out.println(str.reverse());
    }


    /**
     * 输入数组和size 取得size个数的排列组合
     * 例如：{1,2,3,4,5,6,7} size = 3
     * return[1,2,3],[1,3,4].........
     *
     * @author 余思佳
     */
    class MathAlgorithms {
        int[][] groupSplit(int[] arr, int size) {
            return lastArr(arr, 0, size);
        }

        /**
         * @param arr 源数组
         * @param s   所在下标
         * @return 取值
         */
        private int[][] lastArr(int[] arr, int s, int size) {
            if (size < 1) {
                return null;
            }
            int len = 1;
            for (int i = arr.length - s; i > arr.length - s - size; i--) {
                len *= i;
                //i是从第i个位置取，这里指的是从数组的最后一位开始
                //循环终止条件是i最多取到arr.length - s - size个位置，他的组合最开始的位置
            }
            for (int i = 1; i <= size; i++) {
                len /= i;
            }//len算的是组合数
            int[][] result = new int[len][size];
            //定义的result是存储算出来的数字，一共有len个组合数
            int k;
            if (size == 1) {
                k = 0;
                for (int i = s; i < arr.length; i++) {
                    result[k][size - 1] = arr[i];
                    k++;
                }
                return result;

                //如果要求的是一位数的组合数，就是输出的是原来的一维数组，k是0，size是长度
            }
            k = 0;
            for (int i = s; i < arr.length; i++) {//遍历数组
                int[][] last = lastArr(arr, i + 1, size - 1);//此处的递归调用算出来的last是每一个数字，即往组合数里加的第一个数组
                System.out.println(Arrays.deepToString(last));
                //如果size 是3 的递归求出来的先是size为1，再size为2，最后的result[k][0]=arr[i]是连接的
                if (last != null) {
                    for (int[] aLast : last) {
                        System.arraycopy(aLast, 0, result[k], 1, aLast.length);
                        result[k][0] = arr[i];//result[k]里面也是一个数组，arr[i]是取出来的组合数的第一个数
                        //取出来的arr[i]是第一个数字，加到了【0】这个位置
                        //如果要取的size为3的话，复制数组就复制了两个数，再执行循环，把取出来的rr[i]放到第一个位置上
                        System.out.println(Arrays.deepToString(result));
                        k++;
                    }
                }
            }
            return result;
        }


    }
}