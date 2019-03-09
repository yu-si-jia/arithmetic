package search;

/**
 * 二分查找
 */
public class BinaryChop {

    /**
     * 迭代法
     * @param target 查找的目标
     * @param n 数组长度
     * @param arr 目标数组
     * @return
     */
    public int find(int target,int n,int[] arr){
        int l=0,r = n-1;
        while (l <= r) {
//            int mid = (l+r)/2;
            int mid = l+(r-l)/2;
            if (target == arr[mid])
                return mid;
            if (target<arr[mid])
                r = mid-1;
            else
                l = mid + 1;
        }
        return  -1;

    }
    
}
