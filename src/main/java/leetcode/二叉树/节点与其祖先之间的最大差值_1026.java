package leetcode.二叉树;

/**
 * @author HeJiageng
 * @date 2023/9/27
 * @desc
 */
public class 节点与其祖先之间的最大差值_1026 {


    public int maxAncestorDiff(TreeNode root) {
        return def(root, root.val, root.val);
    }

    int def(TreeNode treeNode, int ma, int mi) {
        if (treeNode == null) {
            return 0;
        }

        int diff = Math.max(Math.abs(treeNode.val - ma), Math.abs(treeNode.val - mi));
        ma = Math.max(treeNode.val, ma);
        mi = Math.min(treeNode.val, mi);

        diff = Math.max(diff, def(treeNode.left, ma, mi));
        diff = Math.max(diff, def(treeNode.right, ma, mi));

        return diff;
    }
}
