package arit;

import java.util.Random;

public class MaxHeap {
    private int[] array;//基于堆的完全二叉树
    private int N = 0;//存储在array[1...N]中，array[0]没有使用
    private int maxN;//堆的容量
    public MaxHeap(int maxN) {
        this.maxN = maxN;//创造堆
        this.array = new int[maxN+1];//不使用首个位置，方便计算
    }

    //堆是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    //获取堆的大小
    public int size() {
        return N;
    }

    //堆是否已满
    public boolean isFull() {
        return N == maxN;
    }

    //插入操作
    public void insert(int v) {
        if(isFull()) {
            System.out.println("最大堆已满");
            return;
        }
        array[++N] = v;//先自加再使用，因为N位置已经被占用
        swim(N);//上游N调整顺序
    }

    //删除最大元素
    public int delMax(){
        if(isEmpty()) {
            System.out.println("最大堆已空");
            return array[0];
        }
        int max = array[1];//从根节点得到最大元素
        exch(1,N--);//将其与最后一个结点交换
        sink(1);//恢复堆的有序性
        return max;

    }

    //辅助方法

    //比较i是否小于j
    private boolean less(int i, int j) {
        if((array[i] -array[j]) < 0)
            return true;
        else
            return false;
    }


    public int extractMax(){      //弹出最大值，即根节点
        assert(N>0);//assert是断言 assert [boolean 表达式]
        //如果[boolean表达式]为true，则程序继续执行。
        //如果为false，则程序抛出AssertionError，并终止执行。
        int ret=array[1];
        exch(1,N);    //将最后数放到第一位置,保持完全二叉树的结构
        N--;
        sink(1);         //将第一个数移至合适位置,保持最大堆性质
        return ret;
    }

    //交换元素
    private void exch(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //上浮操作
    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {//子节点和父亲节点比较 再交换实现元素上浮
            exch(k/2, k);
            k = k/2;
        }
    }

    //下沉操作
    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;//此时2k位置就是k位置左子节点
            if(j < N && less(j, j+1))//j要小于j+1
                j++;
            if(!less(k, j))
                break;
            exch(k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        MaxHeap heap=new MaxHeap(100);
        int[] arr = new int[31];
        System.out.print("插入的数为:");
        for(int i=0;i<30;i++){
           arr[i]=new Random().nextInt(100)+1;
            System.out.print(arr[i]+" ");
            heap.insert(arr[i]);
        }
        System.out.println();





        System.out.println();
        System.out.println("删除最大元素");
        int a = heap.delMax();
        System.out.println(a);


        System.out.println();
        System.out.println("新增");
        heap.insert(101);

        System.out.println();
        System.out.print("heap.extractMax():");
        while(!heap.isEmpty()){
            System.out.print(heap.extractMax()+" ");   //从大到小输出
        }
    }
}
