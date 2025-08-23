package 算法练习.力扣练习.深度优先;

public class 相同的树 {

    /*
        给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
        如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     */

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // public static boolean reFlag = false;

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        // 成功条件
        if (p==null && q==null){
            // reFlag = true;
            return true;
        }
        // 失败条件
        if (p==null || q==null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }

        // 深度优先遍历
        // isSameTree(p.left,q.left);
        // isSameTree(p.right,q.right);

        // return reFlag;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    public static void main(String[] args) {
        TreeNode p = new TreeNode(1, new TreeNode(2, null, null), null);
        TreeNode q = new TreeNode(1, null, new TreeNode(2, null, null));
        System.out.println(isSameTree(p, q));
    }

}
