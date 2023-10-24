package leetcode.二叉树;

/**
 * @author ysj
 * @date 2023/10/14
 * @desc
 */
public class 二叉树展开为链表_114 {
    public void flatten(TreeNode root) {
        while (root != null){
            if (root.left != null) {
                TreeNode prev = root.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;

        }

    }
}
