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
