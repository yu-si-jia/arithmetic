package leetcode.二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author HeJiageng
 * @date 2023/10/18
 * @desc
 */
public class 填充每个节点的下一个右侧节点指针_116 {
    public TreeNode connect(TreeNode root) {
        if (root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i< size; i++){
                TreeNode poll = queue.poll();
                if (i < size - 1){
                    poll.next = queue.peek();
                }
                if (poll.left != null){
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                }
            }
        }
        return root;

    }

}
