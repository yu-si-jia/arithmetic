package arit;

import java.util.Arrays;

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




    public static void main(String[] args) {
        int[] a={3,2,1,4,5};
        Some.test1(a);
    }
}
