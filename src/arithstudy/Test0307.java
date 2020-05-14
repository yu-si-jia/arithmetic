package arithstudy;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author YuSiJia
 * @date 2020/3/6
 * @desc
 */
public class Test0307 {
    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] > array[end]) {
                start = mid + 1;
            } else if (array[mid] == array[end]) {
                end = end - 1;
            } else {
                start = mid;
            }
        }
        return array[start];
    }
//
//    public static void main(String[] args) {
//        Test0307 test0307 = new Test0307();
//        int[] arr = {3,4,5,1,2};
//        System.out.println(minNumberInRotateArray(arr));
//    }



}
