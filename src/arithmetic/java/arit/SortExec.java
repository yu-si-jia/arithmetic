package arit;

import java.util.Comparator;
import java.util.Date;

import static java.lang.Math.exp;
import static java.lang.Math.min;
import static java.lang.Math.random;

public class SortExec {

    /**
     * 选择排序：找到数组中最小的元素，其次将它和数组中的第一个元素交换位置，
     * 再在剩余的元素中找到最小的元素和数组第二个元素的位置做交换。
     * 不断的选择剩余元素中最小的
     *
     * @param a：需要排序的数组
     */
    public void slection(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) min = j;
                each(a, i, min);
            }
        }
        show(a);
    }

    /**
     * 插入排序：将数组中的每一个元素插入到其他已经有序的数组中
     * 为了给擦乳的元素提供位置，
     * 需要将其余所有的元素在插入之前都要向右移动一位。
     */

    public void insertSort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                //采用这种写法的时候需要考虑&&后的判断会不会将循环打破，是否是进入循环体内
                System.out.println((j > 0) + "  " + (less(a[j], a[j - 1])));
                each(a, j, j - 1);
            }
        }
        show(a);
    }


    /**
     * 起泡排序：比较两个元素，交换大小
     * 在第一趟比较第一个和第二个数，将小数放前，大数放后。
     * 每次比较都需要从第一个数子开始。
     *
     * @param a:需要排序的数组
     */
    public void bubbleSort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                //less()判断第一个数是否小于第二个数
                if (less(a[j + 1], a[j]))
                    each(a, j, j + 1);
            }
        }
        show(a);
    }


    /**
     * 希尔排序：中心思想是使数组中任意间隔为H的数组都是有序的。
     * 实现希尔排序的一种方法是对于每一个H,
     * 用插入排序将H个字数组独立的进行排序
     */
    public void shellSort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    each(a, j, j - h);
            }
            h = h / 3;
        }
        show(a);
    }


    /**
     * 自顶向下的归并排序
     */
    public class Merage {
        private Comparable[] aux;

        public void sort(Comparable[] a) {
            aux = new Comparable[a.length];
            sort(a, 0, a.length - 1);
            show(a);
        }

        private void sort(Comparable[] a, int lo, int hi) {
            if (hi <= lo) return;

            int mid = lo + (hi - lo) / 2;
            sort(a, lo, mid);
            sort(a, mid + 1, hi);
            merge(a, lo, mid, hi);
        }


        public void sortBU(Comparable[] a, int n) {
            aux = new Comparable[a.length];
            for (int sz = 1; sz <= n; sz += sz) {//进行merge元素个数遍历2.4.6.8
                for (int i = 0; i + sz < n; i += sz + sz) {//i是归并中开始元素位置 i位置平移应该是两个sz位置
                    //第一次从{0到sz-1....从sz到2sz-1
                    //2sz--3sz-1    s32--4sz
                    //对a[i....i+sz-1]和a[i+sz.....i+sz+sz-1]进行归斌排序
                    merge(a, i, i + sz - 1, min(i + sz + sz - 1, n - 1));
                }
            }

            show(a);

        }

        public void merge(Comparable[] a, int lo, int mid, int hi) {
            int i = lo, j = mid + 1;

            for (int k = lo; k <= hi; k++)
                aux[k] = a[k];

            for (int k = lo; k <= hi; k++) {
                if (i > mid)
                    a[k] = aux[j++];
                else if (j > hi)
                    a[k] = aux[i++];
                else if (less(aux[j], aux[i]))
                    a[k] = aux[j++];
                else a[k] = aux[i++];
            }
        }
    }


    public class QuickSort {

        public void sort(Comparable[] a) {
            quickSort(a, 0, a.length - 1);
            show(a);
        }


        public void quickSort(Comparable[] a, int lo, int hi) {
            if (hi <= lo) return;
            int j = partion3(a, lo, hi);
            quickSort(a, lo, j - 1);//将左边部分排序
            quickSort(a, j + 1, hi);//将右边部分排序
        }

        //这个切分数据是单向 正常是从左右两边同时向中间进行
        public int partiton(Comparable[] a, int lo, int hi) {
            int i = lo;
            Comparable v = a[lo];//基准值，一趟排序后让base左边的数都小于base，base右边的数都大于等于base。再分为两个子数组的排序。如此递归下去
            for (int j = lo + 1; j <= hi; j++) {
                if (v.compareTo(a[j]) > 0) {
                    i++;
                    each(a, i, j);
                }
            }
            each(a, lo, i);
            return i;//返回一躺排序后，基准值的下角标
        }

        //选取随机数据作为比较对象
        //优化目标是：使近乎有序的数据排序效率更高
        public int partion2(Comparable[] a, int lo, int hi) {
            each(a, lo, (int) (random() * (hi - lo + 1) + lo));
            int i = lo;
            Comparable v = a[lo];
            for (int j = lo + 1; j <= hi; j++) {
                if (v.compareTo(a[j]) > 0) {
                    i++;
                    each(a, i, j);
                }
            }
            each(a, lo, i);
            return i;//返回一躺排序后，基准值的下角标
        }

        //从左右两边同时进行
        public int partion3(Comparable[] a, int lo, int hi) {
            int i = lo, j = hi + 1;
            Comparable v = a[lo];
            while (true) {
                while (less(a[++i], v)) if (i == hi) break;
                while (less(v, a[--j])) if (i == lo) break;
                if (i >= j) break;
                each(a, i, j);
            }
            each(a, lo, j);
            return j;
        }


        public void partion4(Comparable[] a, int lo, int hi) {
            if (hi <= lo) return;
            int lt = lo, i = lo + 1, gt = hi;
            Comparable v = a[lo];
            while (i <= gt) {
                int cmp = a[i].compareTo(v);
                if (cmp < 0) each(a, lt++, i++);
                else if (cmp > 0) each(a, i, gt--);
                else i++;
            }
            partion4(a, lo, lt - 1);
            partion4(a, gt + 1, hi);
        }

    }


    //不懂
    public static int[] countSort(int[] array, int k) {
        int[] C = new int[k + 1];

        int length = array.length, sum = 0;//获取A数组大小用于构造B数组
        int[] B = new int[length];//构造B数组
        for (int i = 0; i < length; i++) {
            C[array[i]] += 1;// 统计A中各元素个数，存入C数组
        }
        for (int i = 0; i < k + 1; i++)//修改C数组
        {
            sum += C[i];
            C[i] = sum;

            //为什么是前N项和
            //需要算出来前面有几个数值 推算出位置 和是代表数值个数 以及自己本身该存储的位置
        }
        for (int i = length - 1; i >= 0; i--)//遍历A数组，构造B数组
        {

            B[C[array[i]] - 1] = array[i];//将A中该元素放到排序后数组B中指定的位置
            C[array[i]]--;//将C中该元素-1，方便存放下一个同样大小的元素
        }
        return B;//将排序好的数组返回，完成排序
    }


    /**
     * 实现比较的功能
     *
     * @param v：实现了Comparable接口的参数
     * @param w：实现了Comparable接口的参数
     * @return 返回v与m的比较结果
     */
    private boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 实现交换的功能
     *
     * @param a：需要交换的数组
     * @param i：交换的下标
     * @param j：交换的下标
     */
    private void each(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /**
     * 显示已经排好序的数组
     *
     * @param a
     */
    public void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }


}


/**
 * 基数排序：Java
 *
 * @author skywang
 * @date 2014/03/15
 */

class RadixSort {

    /*
     * 获取数组a中最大值
     *
     * 参数说明：
     *     a -- 数组
     *     n -- 数组长度
     */
    private static int getMax(int[] a) {
        int max;

        max = a[0];
        for (int i = 1; i < a.length; i++)
            if (a[i] > max)
                max = a[i];

        return max;
    }

    /*
     * 对数组按照"某个位数"进行排序(桶排序)
     *
     * 参数说明：
     *     a -- 数组
     *     exp -- 指数。对数组a按照该指数进行排序。
     *
     * 例如，对于数组a={50, 3, 542, 745, 2014, 154, 63, 616}；
     *    (01) 当exp=1表示按照"个位"对数组a进行排序
     *    (02) 当exp=10表示按照"十位"对数组a进行排序
     *    (03) 当exp=100表示按照"百位"对数组a进行排序
     *    ...
     */
    private static void countSort(int[] a, int exp) {
        //int output[a.length];    // 存储"被排序数据"的临时数组
        int[] output = new int[a.length];    // 存储"被排序数据"的临时数组
        int[] buckets = new int[10];

        // 将数据出现的次数存储在buckets[]中
        for (int i = 0; i < a.length; i++)
            buckets[ (a[i]/exp)%10 ]++;

        // 更改buckets[i]。目的是让更改后的buckets[i]的值，是该数据在output[]中的位置。
        for (int i = 1; i < 10; i++)
            buckets[i] += buckets[i - 1];

        // 将数据存储到临时数组output[]中
        for (int i = a.length - 1; i >= 0; i--) {
            output[buckets[ (a[i]/exp)%10 ] - 1] = a[i];
            buckets[ (a[i]/exp)%10 ]--;
        }

        // 将排序好的数据赋值给a[]
        for (int i = 0; i < a.length; i++)
            a[i] = output[i];

        output = null;
        buckets = null;
    }

    /*
     * 基数排序
     *
     * 参数说明：
     *     a -- 数组
     */
    public static void radixSort(int[] a) {
        int exp;    // 指数。当对数组按各位进行排序时，exp=1；按十位进行排序时，exp=10；...
        int max = getMax(a);    // 数组a中的最大值

        // 从个位开始，对数组a按"指数"进行排序
        for (exp = 1; max/exp > 0; exp *= 10)
            countSort(a, exp);
    }

    public static void main(String[] args) {
        int i;
        int a[] = {53, 3, 542, 748, 14, 214, 154, 63, 616};

        System.out.printf("before sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        radixSort(a);    // 基数排序

        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}