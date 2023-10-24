package leetcode.二叉树;

/**
 * @author ysj
 * @date 2023/10/14
 * @desc
 */
public class 求根节点到叶节点数字之和_129 {
    public int sumNumbers1(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int preSum) {
        if (root == null) {
            return 0;
        }
        preSum = preSum * 10 + root.val;

        if (root.left == null && root.right==null){
            return preSum;
        }
        preSum = dfs(root.right,preSum)+ dfs(root.left,preSum);
        return preSum;
    }

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
}
