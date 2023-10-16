package leetcode.二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author HeJiageng
 * @date 2023/3/16
 * @desc 101：判断二叉树是否是轴对称
 * 判断二叉树的左子树和右子树是否对称
 * 函数A（左树，右树）功能是返回是否对称
 *
 * def 函数A（左树，右树）：
 * 左树节点值等于右树节点值 且 函数A（左树的左子树，右树的右子树），函数A（左树的右子树，右树的左子树）均为真 才返回真
 */
public class 判断二叉树轴对称_101 {
    public boolean isSymmetric(TreeNode root) {

        if (root==null){
            return true;
        }
        return def(root.left,root.right);
    }

    public boolean def(TreeNode left, TreeNode right) {
        if (left==null && right==null){
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return def(left.left,right.right)&&def(left.right,right.left);
    }

    public boolean checkSymmetricTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode u = queue.poll();
            TreeNode v = queue.poll();
            if (u == null && v == null) {
                continue;
            }
            if (u == null || v == null || u.val != v.val) {
                return false;
            }

            queue.offer(u.right);
            queue.offer(v.left);

            queue.offer(u.left);
            queue.offer(v.right);
        }
        return true;
    }
}
