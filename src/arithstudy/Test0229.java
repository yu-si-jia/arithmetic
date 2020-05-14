package arithstudy;

import arit.Tree;

import java.util.*;

/**
 * @author YuSiJia
 * @date 2020/2/28
 * @desc 二叉树相关
 */
public class Test0229 {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length != in.length|| pre.length==0){
            return null;
        }
        TreeNode node = new TreeNode(pre[0]);
        for (int i=0; i<in.length; i++){
            if (node.val == in[i]){
                node.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                node.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
                break;
            }
        }
        return node;
    }


    public void printTreePre(TreeNode node){
        if (node!=null){
            System.out.println(node.val);
            printTreePre(node.left);
            printTreePre(node.right);
        }
    }

    public void printTreeIn(TreeNode node){
        if (node != null){
            printTreeIn(node.left);
            System.out.println(node.val);
            printTreeIn(node.right);
        }
    }

    public void printTreeBack(TreeNode node){
        if (node != null){
            printTreeBack(node.left);
            printTreeBack(node.right);
            System.out.println(node.val);
        }
    }

    public void printTreeNodeStackPre(TreeNode node){
        if (node == null) {return;}
        Stack<TreeNode> stack = new Stack();
        stack.push(node);
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            System.out.println(treeNode.val);
            if (treeNode.right!=null){
                stack.push(treeNode.right);
            }
            if (treeNode.left != null){
                stack.push(treeNode.left);
            }

        }
    }

    public void printTreeNodeStackIn(TreeNode node){
        if (node == null) {return;}
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || node!= null){
            while (node!=null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            System.out.println(node.val);
            node = node.right;
        }
    }

    public void printTreeNodeBack(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        TreeNode last = null;
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.peek();
            if (treeNode.left == last || treeNode.right == last) {
                last = stack.pop();
                System.out.println(treeNode.val);
                continue;
            }
            if (treeNode.left == null && treeNode.right == null) {
                last = stack.pop();
                System.out.println(treeNode.val);
                continue;
            }
            if (treeNode.right !=null){
                stack.push(treeNode.right);
            }
            if (treeNode.left != null){
                stack.push(treeNode.left);
            }
        }
    }

    public static List<List<Integer>> levels = new ArrayList<List<Integer>>();
    public void printTreeNodeLevel(TreeNode node, int level){
        if (levels.size()==level){
            levels.add(new ArrayList<Integer>());
        }
        levels.get(level).add(node.val);
        if (node.left != null){
            printTreeNodeLevel(node.left,level+1);
        }
        if (node.right != null){
            printTreeNodeLevel(node.right,level+1);
        }
    }


    public void printTreeNodeLevel2(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        int level = 0;
        while (!queue.isEmpty()){
            levels.add(new ArrayList<>());
            int level_length = queue.size();
            for (int i=1; i<=level_length; i++) {
                TreeNode treeNode = queue.remove();
                levels.get(level).add(treeNode.val);
                if (treeNode.left!=null){
                    queue.add(treeNode.left);
                }
                if (treeNode.right!=null){
                    queue.add(treeNode.right);
                }
            }
            level++;
        }
    }



    // 自下而上层序遍历
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null)
            return res;
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> temp = new LinkedList<>();
            for(int i=0; i<count; i++){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            // 每次都添加到第一个位置
            res.add(0, temp);
        }
        return res;
    }

    public ArrayList<ArrayList<Integer> > printTreeNodeZ(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
        int layer = 1;
        // 奇数层栈
        Stack<TreeNode> stack1 = new Stack<>();
        // 偶数层栈
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(pRoot);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            ArrayList<Integer> level = new ArrayList();
            while (layer % 2 == 1 && !stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                if (node != null) {
                    level.add(node.val);
                    stack2.push(node.left);
                    stack2.push(node.right);

                }
            }
            while (layer % 2 != 1 && !stack2.isEmpty()) {
                TreeNode node = stack2.pop();
                if (node != null) {
                    level.add(node.val);
                    stack1.push(node.right);
                    stack1.push(node.left);
                }
            }
            if (level.size()!=0){
                arrayList.add(level);
            }
            layer++;
        }
        return arrayList;
    }

    public void mirrorTree(TreeNode node){
        if (node==null) {return;}
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        mirrorTree(node.left);
        mirrorTree(node.right);
    }

    public void mirrorTree2(TreeNode node){
        if (node==null){return;}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            TreeNode getNode = queue.poll();
            TreeNode temp = getNode.left;
            getNode.left = getNode.right;
            getNode.right = temp;
            if (getNode.left!=null){
                queue.add(getNode.left);
            }
            if (getNode.right!=null){
                queue.add(getNode.right);
            }
        }
    }

    private void swap(TreeNode node){
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    // 二叉树第K层节点的个数
    public int get_k_level_number(TreeNode root, int k){
        if(root == null || k <=0){
            return 0;
        }
        if(root != null && k == 1){
            return 1;
        }
        return get_k_level_number(root.left, k-1) + get_k_level_number(root.right, k-1);
    }

    // 二叉树第K层节点的叶子节点数
    int get_k_level_leaf_number(TreeNode root, int k){
        if(root == null || k <=0){
            return 0;
        }
        if(root != null && k == 1){
            if(root.left == null && root.right == null)
                return 1;
            else
                return 0;
        }
        return get_k_level_number(root.left, k-1) + get_k_level_number(root.right, k-1);
    }

    // 二叉树结构是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if(p == null || q == null)
            return false;
        if(p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }

    // 二叉树是否平衡
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        return Math.abs(maxHigh(root.left) - maxHigh(root.right)) <= 1
                && isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxHigh(TreeNode root){
        if(root == null)
            return 0;
        return Math.max(maxHigh(root.left), maxHigh(root.right))+1;
    }


    public static void main(String[] args) {
        int[] pre = {13,2,4,8,5,9,10};
        int[] in = {4,2,8,13,9,5,10};
        Test0229 test0229 = new Test0229();
        TreeNode node = test0229.reConstructBinaryTree(pre,in);
        test0229.printTreeNodeZ(node);
        System.out.println(levels);
    }
}
