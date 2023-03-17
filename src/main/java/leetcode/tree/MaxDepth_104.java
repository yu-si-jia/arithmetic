package leetcode.tree;

/**
 * @author HeJiageng
 * @date 2023/3/17
 * @desc 104. 二叉树的最大深度
 * 从根节点开始，向下递归，左右子树不为空的递归，和当前的最大取最大,每次递归+1
 */
public class MaxDepth_104 {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }else {
            return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        }
    }
}
