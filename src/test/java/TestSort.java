import arithstudy.Fib;
import arit.SortExec;
import arithstudy.StringToInt;

import java.util.Scanner;

public class TestSort {
    @org.junit.Test
    public void testChange(){
        StringToInt stringToInt = new StringToInt();
        System.out.println(stringToInt.change("dsd551"));
    }

    @org.junit.Test
    public void testSort(){
        SortExec sort = new SortExec();
        Integer[] a = {7,4,1,8,5,2,9,6,3};
        SortExec.Merage merage = sort.new Merage();
        merage.sortBU(a,a.length);
    }

    @org.junit.Test
    public void testQuick(){
        SortExec sort = new SortExec();
        Integer[] a = {7,4,1,8,5,2,9,6,3};
        SortExec.QuickSort quickSort = sort.new QuickSort();
        quickSort.partiton(a,0,a.length-1);
        sort.show(a);

    }
    @org.junit.Test
    public void testCut1(){
        Fib fib = new Fib();
        System.out.println("请输入钢条长度");
        int[] p = {1,5,8,9,10,17,17,20,24,30};
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(fib.cut1(p,n));

    }

}
