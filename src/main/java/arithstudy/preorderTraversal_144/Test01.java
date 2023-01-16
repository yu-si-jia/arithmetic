package arithstudy.preorderTraversal_144;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author andor
 * @date 2020/10/27
 * @desc
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

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




public class Test01 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()) {
            while (curNode != null) {
                result.add(curNode.val);
                stack.push(curNode);
                curNode = curNode.left;
            }
            curNode = stack.pop();
            curNode = curNode.right;
        }

        return result;
    }
}
