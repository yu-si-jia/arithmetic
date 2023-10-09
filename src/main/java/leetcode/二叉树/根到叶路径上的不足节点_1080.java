package leetcode.二叉树;

/**
 * @author HeJiageng
 * @date 2023/10/8
 * @desc 递归判断左右子树是否都要删除，删除则代表为null , 在判断根节点是否要删除，删除代表与操作
 * 因为根节点传入了，没机会删除，所以创建一个前缀节点，传入前缀节点
 */
public class 根到叶路径上的不足节点_1080 {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        TreeNode pre = new TreeNode(0,null,root);
        checkSufficientLeaf(pre,0,limit);
        return pre.right;
    }

    public boolean checkSufficientLeaf(TreeNode node, int sum, int limit) {
        if (node == null) {
            return true;
        }

        if (node.left == null && node.right == null) {
            return node.val + sum < limit;
        }
        boolean left = checkSufficientLeaf(node.left, sum + node.val, limit);
        boolean right = checkSufficientLeaf(node.right, sum + node.val, limit);

        if (left){
            node.left = null;
        }

        if (right){
            node.right = null;
        }

        return left && right;
    }
}
