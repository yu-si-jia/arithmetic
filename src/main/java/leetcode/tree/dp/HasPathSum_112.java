package leetcode.tree.dp;

import leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ysj
 * @date 2023/5/8
 * @desc 112. 路径总和
 */
public class HasPathSum_112 {
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return hasPathSum1(root.left, targetSum - root.val) || hasPathSum1(root.right, targetSum - root.val);
    }


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<>();
        Queue<Integer> queVal = new LinkedList<>();

        queNode.offer(root);
        queVal.offer(root.val);

        while (!queNode.isEmpty()) {
            TreeNode now = queNode.poll();
            Integer temp = queVal.poll();
            if (now.left == null && now.right == null) {
                if (temp == targetSum) {
                    return true;
                }
                continue;
            }
            if (now.left != null) {
                queNode.offer(now.left);
                queVal.offer(temp + now.left.val);
            }
            if (now.right != null) {
                queNode.offer(now.right);
                queVal.offer(temp + now.right.val);
            }
        }
        return false;
    }
}
