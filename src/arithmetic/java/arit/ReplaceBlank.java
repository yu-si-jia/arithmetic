package arit;

/**
 * 把字符串的每个空格替换成%20
 */
public class ReplaceBlank {
    public void replaceBlank(String str) {
        String[] strs = str.split(" ");
        StringBuffer finalStr = new StringBuffer();
        for (int i = 0; i < strs.length; i++) {
            finalStr = finalStr.append(strs[i] + "%20");
        }
        System.out.println(finalStr);

    }


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


    public static void main(String[] args) {
        ReplaceBlank replaceBlank = new ReplaceBlank();
        int[] arr1 = {1, 4, 5, 7, 8};
        int[] arr2 = {2, 3, 6, 9, 10};
        replaceBlank.merge(arr1, arr2);

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
}






