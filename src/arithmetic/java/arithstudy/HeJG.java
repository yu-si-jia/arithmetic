package arithstudy;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class HeJG {
    /**
     * 找到已知字符串中出现最多次的子串
     * 首先找到字符串中出现最多次的1、2位的子串,
     * 判断这些子串的2、3位是否和1、2位出现次数一样多,以此类推
     *
     * @param str 已知字符串
     */
    void mostSubString(String str) {
        String mostStr = "";
        int[] p1 = new int[str.length() / 2 + 1];
        int max = 1;
        for (int j = 0; j < str.length() - 1; j++) {
            int[] p2 = new int[str.length() / 2 + 1];
            int k = 0;
            p2[k++] = j;
            String sub = str.substring(j, j + 2);
            int count = 1;
            for (int i = j + 2; i < str.length() - 1; i++) {
                if (sub.equals(str.substring(i, i + sub.length()))) {
                    count++;
                    p2[k++] = i;
                    i++;
                }
            }
            if (max < count) {
                max = count;
                int i = 0;
                while (i < count) {
                    p1[i] = p2[i];
                    i++;
                }
                mostStr = sub;
            } else if (max == count) {
                boolean isMost = true;
                for (int i = 0; i < count; i++)
                    if (!(p1[i] == (p2[i] - mostStr.length() + 1))) isMost = false;
                if (isMost) mostStr = str.substring(p1[0], p1[0] + mostStr.length() + 1);
            }
        }
        System.out.println(mostStr + "*" + max);
    }

    /**
     * 找出两个字符串中相同的子串
     *
     * @param str1 字符串1
     * @param str2 字符串2
     */
    List<String> sameSubString(String str1, String str2) {
        String subString;
        List<String> list = new ArrayList<String>();
        String maxStr = str1.length() > str2.length() ? str1 : str2;
        String minStr = str1.length() < str2.length() ? str1 : str2;
        for (int i = minStr.length(); i > 0; i--) {     //控制子串长度i
            for (int j = 0; j <= minStr.length() - i; j++) {
                subString = minStr.substring(j, j + i);
                if (maxStr.contains(subString)) {
                    list.add(subString);
                }
            }
            if (!list.isEmpty()) return list;
        }
        return list;
    }

    /**
     * 找出两个字符串中相同子串
     *
     * @param str1      字符串1
     * @param str2      字符串2
     * @param minLength 子串最小长度
     */
    List<String> sameSubString(String str1, String str2, int minLength) {
        List<String> list = new ArrayList<String>();
        String maxStr = str1.length() > str2.length() ? str1 : str2;
        String minStr = str1.length() < str2.length() ? str1 : str2;
        for (int i = 0; i <= minStr.length() - minLength; i++) {
            String subString = "";
            for (int j = minLength; j <= minStr.length() - i; j++) {
                if (maxStr.contains(minStr.substring(i, i + j))) {
                    subString = minStr.substring(i, i + j);
                } else {
                    break;
                }
            }
            if (!"".equals(subString)) {
                list.add(subString);
                i = i + subString.length() - 1;
            }
        }
        return list;
    }

    /**
     * 找到最近的两个数（差绝对值最小）
     *
     * @param array 已知数组
     */
    void nearestNumber(double[] array) {
        int index1 = -1, index2 = -1;
        double min = Math.abs(array[0] - array[1]);
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (Math.abs(array[i] - array[j]) < min) {
                    min = Math.abs(array[i] - array[j]);
                    index1 = i;
                    index2 = j;
                }
            }
        }
        System.out.println("index1 = " + index1 + ",index2=" + index2);
    }


    /**
     * 转置数组
     *
     * @param before 之前数组
     * @param after  之后数组
     * @param m      行
     * @param n      列
     */
    void transposeArray(int[][] before, int[][] after, int m, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                after[i][j] = before[j][i];
            }
        }
    }

    /**
     * M人围圈报数杀死报N的
     *
     * @param N 总人数
     * @param M 杀死位置
     */

    void Josephus(int N, int M) {
        Deque<Integer> deque = new ArrayDeque<Integer>();

        for (int i = 0; i < N; i++) {
            deque.add(i);
        }
        int index = 0;
        while (!deque.isEmpty()) {

            if ((index + 1) % M == 0) {
                System.out.println(deque.pop());

            } else {
                deque.add(deque.pop());
            }
            index++;
        }
    }


    /**
     * 返回不大于log2(N) 的最大整数
     *
     * @param N 对数参数
     * @return 不大于log2(N) 的最大整数
     */
    int lg(int N) {
        int x = 0;
        while (true) {
            int xResult = 1;
            for (int i = 1; i <= x; i++) {
                xResult *= 2;
            }
            if (xResult > N) return x - 1;
            x++;
        }
    }

    /**
     * 结果数组的第i个元素的值为整数i在参数数组中出现的次数。
     *
     * @param a 传入数组
     * @param M 生成数组的长度
     * @return 结果数组
     */
    int[] histogram(int[] a, int M) {
        int[] result = new int[M];
        for (int anA : a) {
            result[anA]++;
        }
        return result;
    }

    /**
     * 欧几里得算法
     */
    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else return gcd(b, a % b);
    }


    static int mystery(int a, int b) {
        if (b == 0) return 0;
        if (b % 2 == 0) return mystery(a + a, b / 2);
        return mystery(a + a, b / 2) + a;
    }

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
        }
        for (int i = 1; i <= size; i++) {
            len /= i;
        }
        int[][] result = new int[len][size];
        int k;
        if (size == 1) {
            k = 0;
            for (int i = s; i < arr.length; i++) {
                result[k][size-1] = arr[i];
                k++;
            }
            return result;
        }
        k = 0;
        for (int i = s; i < arr.length; i++) {
            int[][] last = lastArr(arr, i + 1, size - 1);
            if (last != null) {
                for (int[] aLast : last) {
                    System.arraycopy(aLast,0,result[k],1,aLast.length);
                    result[k][0] = arr[i];
                    k++;
                }
            }
        }
        return result;
    }
}
