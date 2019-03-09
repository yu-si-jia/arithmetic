package arit;

public class Solution {

    /**
     * 旋转数组
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array)
    {
        if(array == null || array.length == 0)
        {
            return 0;
        }
        int p1 = 0;//从前往后走
        int p2 = array.length-1;//从后往前走
        int min = array[p1];//如果没发生旋转，直接将array[0]的值返回，
        int mid = 0;
        //当数组发生旋转了，
        while(array[p1] > array[p2])
        {
            //当两个指针走到挨着的位置时，p2就是最小数了
            if (p2-p1 == 1)
            {
                min = array[p2];
                break;
            }
            mid = (p1+p2)/2;
            //如果中间位置的数既等于p1位置的数又等于P2位置的数
            if(array[p1] == array[mid]&&array[p2]==array[mid])
            {
                min = minInorder(array,p1,p2);
            }
            //若中间位置的数位于数组1，让p1走到mid的位置
            if (array[mid]>array[p1])
            {
                p1 = mid;
            }
            //若中间位置的数位于数组2，让p2走到mid的位置
            if (array[mid]<array[p1])
            {
                p2 = mid;
            }
        }
        return min;
    }
    private int minInorder(int[]array,int p1,int p2)
    {
        int min = array[p1];
        for (int i = p1 + 1; i <= p2; i++)
        {
            if(min > array[i])
            {
                min = array[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a ={3,4,5,1,2};
        System.out.println(solution.minNumberInRotateArray(a));
    }

}
