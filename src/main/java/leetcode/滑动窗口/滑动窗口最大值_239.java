package leetcode.滑动窗口;

import java.util.LinkedList;

/**
 * @author ysj
 * @date 2024/5/23
 * @desc
 */
public class 滑动窗口最大值_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        // right代表右边界
        for (int right = 0; right < nums.length; right++) {
            //如果队列不为空且当前元素大于等于队尾元素，移除队尾元素
            // 直到队列为空或者当前元素小于队尾元素
            while (!queue.isEmpty() && nums[right] >= nums[queue.peekLast()]) {
                queue.removeLast();
            }
            // 存储元素下标
            queue.addLast(right);
            // 计算窗口左边界
            int left = right - k + 1;
            // 当前元素下标小于窗口左下标，要移除队首元素
            if (queue.peekFirst() < left){
                queue.removeFirst();
            }
            // 数组下标从0开始，当右边界right+1 >=k 窗口形成,队首元素是窗口最大值
            if (right +1 >= k){
                res[left] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
}
