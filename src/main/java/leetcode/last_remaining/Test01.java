package leetcode.last_remaining;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author YuSiJia
 * @date 2020/3/30
 * @desc
 * 0, 1, , n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。
 * 求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
 * 则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 *
 * 输入: n = 10, m = 17
 * 输出: 2
 */
public class Test01 {
    public int lastRemaining(int N, int M) {
        Deque<Integer> deque = new ArrayDeque<Integer>();

        for (int i = 0; i < N; i++) {
            deque.add(i);
        }
        int index = 0;
        while (!deque.isEmpty()) {

            if ((index + 1) % M == 0) {
                return (deque.pop());

            } else {
                deque.add(deque.pop());
            }
            index++;
        }
        return 0;
    }
}
