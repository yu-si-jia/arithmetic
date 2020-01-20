package arit;

import java.util.Arrays;

public class IndexMaxHeap {

    //最大索引堆
    protected int[] data;    // 最大索引堆中的数据
    protected int[] indexes;  // 最大索引堆中的索引, indexes[x] = i 表示索引i在x的位置
    //index构建堆，index开始和reserve一样 index根据数据内容比较，然后保存reserve索引，index顺序会变
    protected int[] reverse;  // 最大索引堆中的反向索引, reverse[i] = x 表示索引i在x的位置
    //reverse保存的是index所保存的实际数值的位置，reserve指向的是数据
    protected int count;
    protected int capacity;

    // 构造函数, 构造一个空堆, 可容纳capacity个元素
    public IndexMaxHeap(int capacity) {
        data = new int[capacity + 1];
        indexes = new int[capacity + 1];
        reverse = new int[capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            reverse[i] = 0;//遍历将所有的反向索引设置为0
        }
        count = 0;
        this.capacity = capacity;
    }

    // 返回索引堆中的元素个数
    public int size() {
        return count;
    }

    // 返回一个布尔值, 表示索引堆中是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    // 向最大索引堆中插入一个新的元素, 新元素的索引为i, 元素为item
    // 传入的i对用户而言,是从0索引的
    public void insert(int i, int item) {
        assert (count + 1 <= capacity);//判断数组是否越界
        assert (i + 1 >= 1 && i + 1 <= capacity);

        // 再插入一个新元素前,还需要保证索引i所在的位置是没有元素的。
        assert ( !contain(i) );

        i += 1;
        data[i] = item;//数据数组 从1开始保存
        indexes[count + 1] = i;//index索引是reserve的值 index的数值是数据数组的索引
        reverse[i] = count + 1;//reserve的索引是数据数组的索引 reserve的数值是index的索引

        count++;
        shiftUp( count );
    }

    // 从最大索引堆中取出堆顶元素, 即索引堆中所存储的最大数据
    public int extractMax() {
        assert (count > 0);

        int ret = data[ indexes[1] ];
        swap(indexes, 1, count);
        reverse[ indexes[1] ] = 1;
        reverse[ indexes[count] ] = 0;
        count--;

        shiftDown(1);

        return ret;
    }

    // 从最大索引堆中取出堆顶元素的索引
    int extractMaxIndex() {
        assert (count > 0);

        int ret = indexes[1] - 1;
        swap(indexes, 1, count);
        reverse[ indexes[1] ] = 1;
        reverse[ indexes[count] ] = 0;
        count--;
        shiftDown(1);
        return ret;
    }

    // 看索引i所在的位置是否存在元素
    private boolean contain(int i) {
        assert (i + 1 >= 1 && i + 1 <= capacity);
        return reverse[i+1] != 0;
    }

    private void shiftUp(int k) {
        while (k > 1 && data[ indexes[k / 2] ]<data[ indexes[k] ]) {
            swap(indexes, k / 2, k);
            k /= 2;
        }
    }

    private void shiftDown(int k) {
        while (2*k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[ indexes[j] ]< data[ indexes[j+1] ]) {
                j += 1;
            }

            if (data[ indexes[k] ]>data[ indexes[j] ]) {
                break;
            }

            swap(indexes, k, j);
            k = j;
        }
    }

    // 交换索引堆中的索引i和j
    // 由于有了反向索引reverse数组，
    // indexes数组发生改变以后， 相应的就需要维护reverse数组
    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;

        reverse[ indexes[i] ] = i;
        reverse[ indexes[j] ] = j;
    }

    // 获取最大索引堆中索引为i的元素
    public int getItem(int i) {
        assert (contain(i));
        return data[i + 1];
    }

    // 将最大索引堆中索引为i的元素修改为newItem
    public void change(int i, int newItem) {
        assert(contain(i));

        i += 1;
        data[i] = newItem;

        int j = reverse[i];
        shiftUp(j);
        shiftDown(j);
    }

    // 获取最大索引堆中的堆顶元素
    int getMax() {
        assert (count > 0);
        return data[1];
    }

    // 测试索引堆中的索引数组index和反向数组reverse
    // 注意:这个测试在向堆中插入元素以后, 不进行extract操作有效
    public boolean testIndexes(){

        int[] copyIndexes = new int[count+1];
        int[] copyReverseIndexes = new int[count+1];

        for( int i = 0 ; i <= count ; i ++ ) {
            copyIndexes[i] = indexes[i];
            copyReverseIndexes[i] = reverse[i];
        }

        copyIndexes[0] = 0;
        copyReverseIndexes[0] = 0;
        Arrays.sort(copyIndexes);
        Arrays.sort(copyReverseIndexes);

        // 在对索引堆中的索引和反向索引进行排序后,
        // 两个数组都应该正好是1...count这count个索引
        boolean res = true;
        for( int i = 1 ; i <= count ; i ++ )
            if( copyIndexes[i-1] + 1 != copyIndexes[i] ||
                    copyReverseIndexes[i-1] + 1 != copyReverseIndexes[i] ){
                res = false;
                break;
            }

        if( !res ){
            System.out.println("Error!");
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int N = 15;
        IndexMaxHeap indexMaxHeap = new IndexMaxHeap(N);
        for (int i = 0; i < N; i++) {
            indexMaxHeap.insert(i, (int) (Math.random() * N));
        }

//        assert indexMaxHeap.testIndexes();

        for (int i = 0;i<N;i++){
            System.out.print(indexMaxHeap.extractMax()+"  ");
        }
    }


}