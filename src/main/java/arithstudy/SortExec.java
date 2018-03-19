package arithstudy;

import java.util.Comparator;

public class SortExec {

    /**
     * 选择排序：找到数组中最小的元素，其次将它和数组中的第一个元素交换位置，
     *         再在剩余的元素中找到最小的元素和数组第二个元素的位置做交换。
     *         不断的选择剩余元素中最小的
     * @param a：需要排序的数组
     */
    public void slection(Comparable[] a){
        int N = a.length;
        for (int i = 0; i<N; i++){
            int min = i;
            for (int j = i+1; j<N; j++){
                if (less(a[j],a[min])) min = j;
                each(a,i,min);
            }
        }
        show(a);
    }

    /**
     * 插入排序：将数组中的每一个元素插入到其他已经有序的数组中
     *         为了给擦乳的元素提供位置，
     *         需要将其余所有的元素在插入之前都要向右移动一位。
     */

    public void insertSort(Comparable[] a){
        int N = a.length;
        for (int i = 1; i<N;i++){
            for (int j = i; j>0&&less(a[j],a[j-1]);j--){
                //采用这种写法的时候需要考虑&&后的判断会不会将循环打破，是否是进入循环体内
                System.out.println((j>0)+"  "+(less(a[j],a[j-1])));
                each(a,j,j-1);
            }
        }
        show(a);
    }


    /**
     * 起泡排序：比较两个元素，交换大小
     *         在第一趟比较第一个和第二个数，将小数放前，大数放后。
     *         每次比较都需要从第一个数子开始。
     * @param a:需要排序的数组
     */
    public void bubbleSort(Comparable[] a){
        int N = a.length;
        for (int i = 0; i<N-1; i++){
            for (int j = 0; j<N-i-1;j++){
                //less()判断第一个数是否小于第二个数
                if(less(a[j+1],a[j]))
                each(a,j,j+1);
            }
        }
        show(a);
    }


    /**
     * 希尔排序：中心思想是使数组中任意间隔为H的数组都是有序的。
     *         实现希尔排序的一种方法是对于每一个H,
     *         用插入排序将H个字数组独立的进行排序
     */
    public void shellSort(Comparable[] a){
        int N = a.length;
        int h = 1;
        while (h<N/3) h = 3*h+1;
        while (h>=1){
            for (int i = h; i<N; i++){
                for (int j = i; j>=h&&less(a[j],a[j-h]);j -= h)
                    each(a,j,j-h);
            }
            h = h/3;
        }
        show(a);
    }

    /**
     * 自顶向下的归并排序
     */
    public class Merage{
        private  Comparable[] aux;

        public  void sort(Comparable[] a){
            aux = new Comparable[a.length];
            sort(a,0,a.length-1);
            show(a);
        }

        private void sort(Comparable[] a,int lo, int hi){
            if (hi<=lo) return;

            int mid = lo + (hi -lo)/2;
            sort(a,lo,mid);
            sort(a,mid+1,hi);
            merge(a,lo,mid,hi);
        }

        public void merge(Comparable[] a,int lo,int mid,int hi){
            int i = lo,j=mid+1;

            for (int k = lo;k<=hi;k++)
                aux[k] = a[k];

            for (int k = lo;k<=hi;k++){
                if (i>mid)
                    a[k] = aux[j++];
                else if (j>hi)
                    a[k] = aux[i++];
                else if (less(aux[j],aux[i]))
                    a[k] = aux[j++];
                else a[k] = aux[i++];
            }
        }
    }


    /**
     * 实现比较的功能
     * @param v：实现了Comparable接口的参数
     * @param w：实现了Comparable接口的参数
     * @return 返回v与m的比较结果
     */
    private boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 实现交换的功能
     * @param a：需要交换的数组
     * @param i：交换的下标
     * @param j：交换的下标
     */
    private void each(Object[] a,int i,int j){
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /**
     * 显示已经排好序的数组
     * @param a
     */
    public void show(Comparable[] a){
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i]+" ");
        }
    }

    public boolean isSorted(Comparable[] a){
        for (int i = 1; i<a.length; i++){
            if(less(a[i],a[i-1])) return false;
        }
        return true;
    }

}
