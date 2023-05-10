package leetcode.tree;

/**
 * @author ysj
 * @date 2023/1/31
 * @desc 二叉树的遍历 94；102；144；145987；107
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}