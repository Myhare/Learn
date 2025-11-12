package 算法练习.力扣练习.困难难度;

public class 二叉树的最大路径和 {

    public static int max = Integer.MIN_VALUE;


    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root) {
        // 由下到上，获取最大值
        dfs(root);
        return max;
    }

    public static int dfs(TreeNode node){
        if (node == null){
            return 0;
        }
        int leftValue = Math.max(dfs(node.left), 0);
        int rightValue = Math.max(dfs(node.right), 0);
        max = Math.max(max, leftValue + rightValue + node.val);
        return node.val + Math.max(leftValue, rightValue);
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
