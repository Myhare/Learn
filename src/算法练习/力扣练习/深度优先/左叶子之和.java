package 算法练习.力扣练习.深度优先;

public class 左叶子之和 {


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

    public static int count;

    public static int sumOfLeftLeaves(TreeNode root) {
        count = 0;
        dfs(root);
        return count;
    }

    // 深度优先遍历求左子树的和
    public static void dfs(TreeNode node){
        if (node == null){
            return;
        }
        if (node.left != null && node.left.left == null && node.left.right == null){
            count += node.left.val;
        }
        dfs(node.left);
        dfs(node.right);
    }

    // 求一个二叉树的所有左叶子的和
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );
        System.out.println(sumOfLeftLeaves(root));
    }

}
