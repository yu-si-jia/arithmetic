package leetcode.二叉树;

/**
 * @author ysj
 * @date 2023/9/11
 * @desc
 */
public class 二叉树中的最大路径和_124 {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        traversal(root);
        return maxSum;
    }


    public int traversal(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMaxValue = Math.max(traversal(root.left), 0);
        int rightMaxValue = Math.max(traversal(root.right), 0);

        int priceNewPath = root.val + leftMaxValue + rightMaxValue;

        maxSum = Math.max(maxSum, priceNewPath);

        return root.val + Math.max(leftMaxValue, rightMaxValue);
    }
}
