package leetcode.二叉树;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author HeJiageng
 * @date 2023/3/22
 * @desc 226. 翻转二叉树
 */
public class 翻转二叉树_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(right);
        return root;
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;

        Deque<TreeNode> stack = new ArrayDeque();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.poll();
            if (node.left!=null) stack.push(node.left);
            if (node.right!=null) stack.push(node.right);

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;

    }

}
