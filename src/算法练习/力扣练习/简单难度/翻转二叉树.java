package 算法练习.力扣练习.简单难度;

public class 翻转二叉树 {

    public TreeNode flipTree(TreeNode root) {
        if (root == null){
            return null;
        }
        // 不能直接替换，一个节点递归完了后直接改指向会影响下一次递归
        TreeNode leftNode = flipTree(root.left);
        TreeNode rightNode = flipTree(root.right);
        root.left = rightNode;
        root.right = leftNode;
        return root;
    }

    public static void main(String[] args) {

    }

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


}
