package 算法练习.力扣练习.简单难度;

public class 二叉树最近公共祖先 {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if (root == p){
            return p;
        }
        if (root == q){
            return q;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if (leftNode == null && rightNode != null){
            return rightNode;
        }
        if (leftNode != null && rightNode == null){
            return leftNode;
        }
        if (leftNode != null && rightNode != null){
            return root;
        }
        return null;
    }

    public static void main(String[] args) {

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


}
