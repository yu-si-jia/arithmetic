package leetcode.二叉树;

import arit.Tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author HeJiageng
 * @date 2024/1/21
 * @desc
 */
public class 二叉树最小深度_111 {
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = queue.poll();
                if (cur.right == null && cur.left == null) {
                    return depth;
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
            }
            depth ++;
        }
        return depth;
    }

    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int m = minDepth1(root.left);
        int n = minDepth1(root.right);
        return root.left == null || root.right == null ? m + n + 1 : Math.min(m, n) + 1;
    }


}
