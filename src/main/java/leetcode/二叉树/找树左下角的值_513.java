package leetcode.二叉树;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author HeJiageng
 * @date 2023/10/16
 * @desc 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 队列 先右后左， 队列是先进先出，所以右子树弹出，剩下左子树
 */
public class 找树左下角的值_513 {
    public int findBottomLeftValue(TreeNode root) {
        int result = 0;

        Deque<TreeNode> queue = new ArrayDeque();
        queue.offer(root);

        while (!queue.isEmpty()){
            root = queue.poll();
            if (root.right!=null){
                queue.offer(root.right);
            }
            if (root.left != null ){
                queue.offer(root.left);
            }


            result = root.val;
        }

        return result;
    }
}
