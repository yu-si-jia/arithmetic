package leetcode.二叉树;

import java.util.*;

/**
 * @author ysj
 * @date 2023/1/31
 * @desc 94. 二叉树的中序遍历
 */
public class 二叉树中序遍历_94 {

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root,result);
        return result;
    }

    /**
     * 二叉树中序递归
     * @param node
     * @param result
     */
    public void inorder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }

    /**
     * 非递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root == null) return Collections.emptyList();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }


}
