package leetcode.tree;

/**
 * @author HeJiageng
 * @date 2023/3/22
 * @desc 226. 翻转二叉树
 */
public class InvertTree_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(right);
        return root;
    }


}
