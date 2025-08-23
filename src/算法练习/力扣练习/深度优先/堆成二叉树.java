package 算法练习.力扣练习.深度优先;

public class 堆成二叉树 {


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


    // 求一个数是不是平衡二叉树
    public boolean isSymmetric(TreeNode root) {
        if (root==null){
            return true;
        }
        // 如果一个树的左子树和右子树相等，name它就是平衡二叉树
        return dfs(root.left,root.right);
    }

    public static boolean dfs(TreeNode left,TreeNode right){
        if (left==null && right==null){
            return true;
        }
        // 上面已经判断了两个树不可能同时为空
        if (left==null || right==null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }

        return dfs(left.left,right.right) && dfs(left.right,right.left);
    }

    public static void main(String[] args) {

    }

}
