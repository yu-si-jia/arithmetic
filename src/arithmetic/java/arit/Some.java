package arit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Some {

    /**
     * 题目描述
     * 给定一个长度为n的整数数组a，元素均不相同，问数组是否存在这样一个片段，只将该片段翻转就可以使整个数组升序排列。
     * 其中数组片段[l,r]表示序列a[l], a[l+1], ..., a[r]。原始数组为
     * a[1], a[2], ..., a[l-2], a[l-1], a[l], a[l+1], ..., a[r-1], a[r], a[r+1], a[r+2], ..., a[n-1], a[n]，
     * 将片段[l,r]反序后的数组是
     * a[1], a[2], ..., a[l-2], a[l-1], a[r], a[r-1], ..., a[l+1], a[l], a[r+1], a[r+2], ..., a[n-1], a[n]。
     */
    void test1(int[] array) {
        int len = array.length;
        int[] copyArray = new int[len];
        for (int i = 0; i < len; i++) {
            copyArray[i] = array[i];
        }
        Arrays.sort(copyArray);
        int left = 0, right = len - 1;
        //这俩步是找到排好顺序的数组和没有排好顺序的数组左右各是从第几个元素不相同的
        while (left < len && copyArray[left] == array[left]) left++;
        while (right >= 0 && copyArray[right] == array[right]) right--;
        int i;
        for (i = 0; i <= right - left; i++) {
            if (copyArray[left + i] != array[right - i])
                break;
        }
        if (i > right - left)
            System.out.println("yes");
        else
            System.out.println("no");
    }

    /**
     * 将约德尔人的历史的每个阶段都用一个字符表达出来。(包括可写字符,不包括空格。)。
     * 然后将这个字符串转化为一个01串。转化规则是如果这个字符如果是字母或者数字，这个字符变为1,其它变为0。
     * 然后将这个01串和黑默丁格观测星空得到的01串做比较，得到一个相似率。相似率越高,则约德尔的未来越光明。
     * 样例输入   @!%12dgsa      010111100
     * 样例输出    66.67%
     *
     * @param his
     * @param see
     */

    void test2(String his, String see) {
        String transHis = "";
        for (int i = 0; i < his.length(); i++) {
            char c = his.charAt(i);
            if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' || c >= '0' && c <= '9') {
                transHis = transHis + "1";
            } else {
                transHis = transHis + "0";
            }
        }

        int same = 0;
        for (int i = 0; i < transHis.length(); i++) {
            if (transHis.charAt(i) == see.charAt(i)) {
                same++;
            }
        }

        float out = (float) same * 100 / (float) transHis.length();
        System.out.printf("%.2f%%", out);
    }


    /**
     * 10-15.16
     * 有两个排好虚的数组A1,A2  内存在A1末尾有足够多的空间容纳A2
     * 实现一个函数把A2中的所有数字插入到A1中并且所有的数字都是有序的
     */
    void merge(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int len = len1 + len2;
        int arr[] = new int[len];
        int j = len1 - 1;
        int i = len2 - 1;
        len--;
        while (i >= 0 && j >= 0) {
            //从后向前比较
            if (arr2[i] > arr1[j]) {
                //将第二个数组的最后第i个元素放入arr中
                arr[len--] = arr2[i];
                i--;//“指针”后移一位
            } else if (arr2[i] <= arr1[j]) {
                //将第一个数组的最后第i个元素放入arr中
                arr[len--] = arr1[j];
                j--;//“指针”后移一位
            }
        }
        if (i > j) {
            //将剩余的数组1或者数组2的元素全部追加到数组arr
            while (i >= 0) {
                arr[len--] = arr2[i--];
            }
        } else {
            while (j >= 0) {
                arr[len--] = arr1[j--];
            }
        }
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");
        }
    }

    /**
     * 计算数的次方
     *
     * @param power 底数
     * @param truth 次方
     */
    public static void computationOfPower(int power, int truth) {
        int result = 0;
        for (int i = 0; i < power; i++) {
            if (result != 0) {
                result = result * truth;
            } else {
                result = truth;
            }
        }
        System.out.println(result);
        ;
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

    /**
     * 第一行输入字符串的个数
     * 第二行输入字符串
     * 如果是1 0 挨着就删除，返回删除后的长度
     * 例子：5
     * 10110
     * 1
     */
    public static void tecent1() {
        Scanner scanner = new Scanner(System.in);
        while ((scanner.hasNext())) {
            int length = Integer.valueOf(scanner.nextLine());
            String string = scanner.nextLine();
            if (string.length() != length) {
                continue;
            }
            if (length == 0 || length == 1) {
                System.out.println(length);
                continue;
            }
            int start1 = 0, end1 = 0, start2 = 1, end2 = length;
            while (start2 < end2) {
                int s = (int) string.charAt(end1);//s,e比较的是ascii码
                int e = (int) string.charAt(start2);
                if (s != e) {//第一位和第二位不相等
                    if (start1 == end1) {//最开始的状态，下标未开始移动
                        end1 = start2 + 1;//结束的位置是start2+1
                        start1 = end1;//新开始的位置
                        start2 += 2;
                    } else {
                        end1 = start1;
                        start2++;
                    }
                    length -= 2;

                } else {
                    start1 = end1;
                    end1 = start2;
                    start2++;

                }
            }
            System.out.println(length);
        }
    }

    public static void tecent2(int n, int[] nums) {
        if (nums.length != n) {
            throw new RuntimeException("输入不合法");
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) nums[i] = -1;
            result += nums[i];
        }

        if (result < 0) System.out.println(0 - result);
        if (result > 0) System.out.println(result);
    }



    /**
     * Q去打怪兽，也可以花钱雇佣怪兽，
     * 例如：3
     * 8 5 10
     * 1 1 2
     * 代表会遇见三个怪兽 武力值分别是8 5 10 雇佣钱数是 1 1 2 武力值不会消耗
     * 要安全通过雇佣一号和二号怪兽就好 花费2金币
     * @param n 怪兽数量
     * @param attack 怪兽武力值
     * @param price 怪兽价格
     */
    public static void tencent(int n, int[] attack, int[] price) {
        int maxSumP = 0;
        int maxA = 0;
        for (int i = 0; i < n; i++) {
            maxSumP += price[i];
            if (maxA < attack[i]) {
                maxA = attack[i];
            }
        }
        int[][] p = new int[n + 1][maxSumP + 1];
        for (int i = 1; i <= maxSumP; i++) {
            p[1][i] = attack[0];
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= maxSumP; j++) {
                if (j > price[i - 1]) {//当前拥有的钱数够雇佣当前怪
                    p[i][j] = p[i-1][j - price[i - 1]] + attack[i - 1];
                    //当前拥有的钱数-雇佣当前怪的钱数剩下的钱数在打前一个怪时有的武力值+当前怪武力值
                } else {
                    p[i][j] = p[i-1][j];//在有j钱数时打i-1怪的武力值
                }
            }
        }
        for (int i = 1; i < maxSumP; i++) {
            if (p[n][i] >= maxA) {
                System.out.println(i);
                break;
            }
        }
    }


    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("abc   ");
        System.out.println(stringBuffer.length());
    }
}