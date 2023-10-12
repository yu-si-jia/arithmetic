package leetcode.二叉树;

import java.util.*;

/**
 * @author ysj
 * @date 2023/10/11
 * @desc
 */
public class 二叉树路径和2_113 {
    Map<TreeNode, TreeNode> map = new HashMap<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueSum = new LinkedList<>();

        queueNode.offer(root);
        queueSum.offer(0);

        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            int res = node.val + queueSum.poll();
            if (root.right == null && root.left == null) {
                if (res == targetSum) {
                    getPath(node);
                }
            } else {
                if (root.left != null) {
                    map.put(node, node.left);
                    queueNode.offer(node.left);
                    queueSum.offer(res);
                }

                if (root.right != null) {
                    map.put(node,node.right);
                    queueNode.offer(node.right);
                    queueSum.offer(res);
                }

            }
        }

        return result;
    }

    private void getPath(TreeNode node) {
        List<Integer> temp = new ArrayList<>();

        while (node != null) {
            temp.add(node.val);
            node = map.get(node);
        }

        Collections.reverse(temp);
        result.add(temp);
    }
}
