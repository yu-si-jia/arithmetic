package leetcode.tree;

/**
 * @author HeJiageng
 * @date 2023/3/14
 * @desc 543: 二叉树的直径
 * 递归，算左右两个支最大值，并及时更新全局变量
 * 遍历每一个节点，以每一个节点为中心点计算最长路径（左子树边长+右子树边长），更新全局变量max。
 */
public class DiameterOfBinaryTree_543 {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null){
            return max;
        }
        def(root);
        return max;
    }

    public int def(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }
        int left = root.left == null ? 0 : def(root.left) + 1;
        int right = root.right == null ? 0 : def(root.right) + 1;
        max = Math.max(max, left + right);
        return Math.max(left, right);
    }
}
