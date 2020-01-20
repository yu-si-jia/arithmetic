package arit;

import java.util.Arrays;

/**
 * @author YuSiJia
 * @date 2020/1/20
 * @desc
 */
public class ArrayTest {
    /**
     * 题目描述
     * 给定一个长度为n的整数数组a，元素均不相同，问数组是否存在这样一个片段，只将该片段翻转就可以使整个数组升序排列。
     * 其中数组片段[l,r]表示序列a[l], a[l+1], ..., a[r]。原始数组为
     * a[1], a[2], ..., a[l-2], a[l-1], a[l], a[l+1], ..., a[r-1], a[r], a[r+1], a[r+2], ..., a[n-1], a[n]，
     * 将片段[l,r]反序后的数组是
     * a[1], a[2], ..., a[l-2], a[l-1], a[r], a[r-1], ..., a[l+1], a[l], a[r+1], a[r+2], ..., a[n-1], a[n]。
     * 解题思路：将数组排好序，与原数组做对比，左右指针，计算到不相同的地方，在做对比
     */
    void arrayTest(int[] array) {
        int len = array.length;
        int[] copyArray = new int[len];
        for (int i = 0; i < len; i++) {
            copyArray[i] = array[i];
        }
        Arrays.sort(copyArray);
        int left = 0, right = len - 1;
        //这俩步是找到排好顺序的数组和没有排好顺序的数组左右各是从第几个元素不相同的
        while (left < len && copyArray[left] == array[left]) {
            left++;
        }
        while (right >= 0 && copyArray[right] == array[right]) {
            right--;
        }
        int i;
        for (i = 0; i <= right - left; i++) {
            if (copyArray[left + i] != array[right - i]) {
                break;
            }
        }
        if (i > right - left) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    /**
     * 10-15.16
     * 有两个排好虚的数组A1,A2  内存在A1末尾有足够多的空间容纳A2
     * 实现一个函数把A2中的所有数字插入到A1中并且所有的数字都是有序的
     * 解题思路：可分为从前比较的做法，和从后比较
     * 从后比较，设置两个指针i,j分别指向a1与a2的最后一个元素，选择大的放入result result--才能保证不撞车
     * 当a2和a1任意一个数组放入完毕，另一个就全部放入result
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
     * 旋转数组:把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int p1 = 0;//从前往后走
        int p2 = array.length - 1;//从后往前走
        int min = array[p1];//如果没发生旋转，直接将array[0]的值返回，
        int mid = 0;
        //当数组发生旋转了，
        while (array[p1] > array[p2]) {
            //当两个指针走到挨着的位置时，p2就是最小数了
            if (p2 - p1 == 1) {
                min = array[p2];
                break;
            }
            mid = (p1 + p2) / 2;
            //如果中间位置的数既等于p1位置的数又等于P2位置的数
            if (array[p1] == array[mid] && array[p2] == array[mid]) {
                min = minInorder(array, p1, p2);
            }
            //若中间位置的数位于数组1，让p1走到mid的位置
            if (array[mid] > array[p1]) {
                p1 = mid;
            }
            //若中间位置的数位于数组2，让p2走到mid的位置
            if (array[mid] < array[p1]) {
                p2 = mid;
            }


        }
        return min;
    }

    private int minInorder(int[] array, int p1, int p2) {
        int min = array[p1];
        for (int i = p1 + 1; i <= p2; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }


    public int minNumberInRotateArray1(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            } else {
                if (i == array.length - 2) {
                    return array[0];
                }
            }
        }
        return 0;
    }

    /**
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排列
     * 每一列都按照从上到下递增的顺序排序
     * 完成一个函数，输入这样的二维数组和一个整数
     * 判断数组是否含有整数
     */
    public boolean Find(int target, int[][] array) {
        int rows = array.length;
        int col = array[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                if (target == array[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    //根据有序的特性进行查找
    /*从左下角开始查找，大于左下角删除一行，小于左下角删除一列*/
    public boolean Find2(int target, int[][] array) {

        for (int i = array.length - 1, j = 0; i >= 0 && j < array[0].length; ) {//控制循环
            if (target == array[i][j]) {
                return true;
            } else if (target > array[i][j]) {
                j++;
                continue;
            } else if (target < array[i][j]) {
                i--;
                continue;
            }
        }
        return false;
    }

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
     * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     */
    public int[] reOrderArray(int[] array) {
        int i, j, m = 0, n = array.length - 1;
        int[] result = new int[array.length];
        for (i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                result[m] = array[i];
                m++;
            }

        }
        for (j = array.length - 1; j >= 0; j--) {
            if (array[j] % 2 == 0) {
                result[n] = array[j];
                n--;
            }
        }
        for (i = 0; i < array.length; i++) {
            array[i] = result[i];
        }
        return array;
    }

}
