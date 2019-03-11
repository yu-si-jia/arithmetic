package arit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Some {

    /**
     * 题目描述
     给定一个长度为n的整数数组a，元素均不相同，问数组是否存在这样一个片段，只将该片段翻转就可以使整个数组升序排列。
     其中数组片段[l,r]表示序列a[l], a[l+1], ..., a[r]。原始数组为
     a[1], a[2], ..., a[l-2], a[l-1], a[l], a[l+1], ..., a[r-1], a[r], a[r+1], a[r+2], ..., a[n-1], a[n]，
     将片段[l,r]反序后的数组是
     a[1], a[2], ..., a[l-2], a[l-1], a[r], a[r-1], ..., a[l+1], a[l], a[r+1], a[r+2], ..., a[n-1], a[n]。
     */
    public static void test1(int[] array){
        int len = array.length;
        int[] copyArray=new int[len];
        for(int i=0;i<len;i++)
        {
            copyArray[i] = array[i];
        }
        Arrays.sort(copyArray);
        int left = 0,right = len-1;
        while(left<len && copyArray[left]==array[left]) left++;
        while(right>=0 && copyArray[right]==array[right]) right--;
        int i;
        for(i=0;i<=right-left;i++)
        {
            if(copyArray[left+i]!=array[right-i])
                break;
        }
        if(i>right-left)
            System.out.println("yes");
        else
            System.out.println("no");
    }

    /**
     * 将约德尔人的历史的每个阶段都用一个字符表达出来。(包括可写字符,不包括空格。)。
     * 然后将这个字符串转化为一个01串。转化规则是如果这个字符如果是字母或者数字，这个字符变为1,其它变为0。
     * 然后将这个01串和黑默丁格观测星空得到的01串做比较，得到一个相似率。相似率越高,则约德尔的未来越光明。
     *  样例输入   @!%12dgsa      010111100
     *  样例输出    66.67%
     * @param his
     * @param see
     */

    public static void test2(String his,String see) {
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
        for (int i = 0;i<transHis.length();i++ ){
            if (transHis.charAt(i)==see.charAt(i)){
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
    public void merge(int[] arr1, int[] arr2) {
        int len1 = arr1.length;//数组1长度
        int len2 = arr2.length;//数组2长度
        int len = len1 + len2;//合并后数组长度
        int arr[] = new int[len];//合并后的数组
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
     * 把字符串的每个空格替换成%20
     */
    public String replaceSpace(StringBuffer str) {
        //toCharArray()函数会返回一个新的数组，
        //因此就算原数组定义了长度，返回的新数组会取代它
        char[] ch = str.toString().toCharArray();

        int spacenum = 0;  //空格数量
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ' ') {
                spacenum++; //如果是空格，加1
            }
        }
        char[] ch1 = new char[2 * spacenum + str.length()];
        int len = 2 * spacenum + str.length() - 1;

        for (int i = ch.length - 1; i >= 0; i--) {
            if (ch[i] != ' ') {
                ch1[len--] = ch[i];
            } else {
                ch1[len--] = '0';
                ch1[len--] = '2';
                ch1[len--] = '%';
            }
        }
        return String.valueOf(ch1);
    }

    /**
     * 计算数的次方
     * @param power 底数
     * @param truth 次方
     */
    public static void computationOfPower(int power,int truth){
        int result = 0;
        for (int i = 0;i<power ; i++){
            if (result!=0){
                result = result*truth;
            }else{
                result = truth;
            }
        }
        System.out.println(result);;
    }

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
     * 输出描述:List<String> sameSubString(String str1, String str2) {
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
     * 找到已知字符串中出现最多次的子串
     * 首先找到字符串中出现最多次的1、2位的子串,
     * 判断这些子串的2、3位是否和1、2位出现次数一样多,以此类推
     *
     * @param str 已知字符串
     */
    static void mostSubString(String str) {
        String mostStr = "";
        //求子串最大的也不会超过原串的一半
        int[] p1 = new int[str.length() / 2 + 1];
        int max = 1;//最大次数
        for (int j = 0; j < str.length() - 1; j++) {
            int[] p2 = new int[str.length() / 2 + 1];
            int k = 0;
            p2[k++] = j;
            String sub = str.substring(j, j + 2);//前闭后开的区间
            int count = 1;
            for (int i = j + 2; i < str.length() - 1; i++) {//从j+2往后找相同子串 并且记录次数
                String euqalStr = str.substring(i, i + sub.length());
                if (sub.equals(euqalStr)) {
                    count++;//记录出现的次数
                    p2[k++] = i;//？？？？在源数组中的位置
                    i++;
                }
            }
            if (max < count) {
                max = count;
                int i = 0;
                while (i < count) {
                    p1[i] = p2[i];//？？？？
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

    public static void main(String[] args) {
        int[] a={3,2,1,4,5};
        Some.mostSubString("abcddsdwdekfabcdssddd");
    }
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