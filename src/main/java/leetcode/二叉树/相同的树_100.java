package leetcode.二叉树;

/**
 * @author ysj
 * @date 2023/9/1
 * @desc
 */
public class 相同的树_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null){
            return true;
        }else if (p == null || q==null){
            return false;
        }else if (p.val != q.val){
            return false;
        }else {
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
    }
}
