package 算法练习.力扣练习.回溯;

public class 二叉树的最大路径和 {


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


    public static int maxValue = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        dfs(root);
        return maxValue;
    }

    public static int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        // 维护最大值
        int leftValue = dfs(root.left);
        leftValue = Math.max(leftValue, 0);
        int rightValue = dfs(root.right);
        rightValue = Math.max(rightValue, 0);
        maxValue = Math.max( leftValue + rightValue + root.val, maxValue);
        // 返回当前节点的最大贡献值
        return Math.max(leftValue, rightValue) + root.val;
    }

    public static void main(String[] args) {
        // TreeNode root = new TreeNode(-10);
        // root.left = new TreeNode(9);
        // TreeNode rightNode = new TreeNode(20);
        // rightNode.left = new TreeNode(15);
        // rightNode.right = new TreeNode(7);
        // root.right = rightNode;

        TreeNode root = new TreeNode(2, new TreeNode(-1), null);

        System.out.println(maxPathSum(root));
    }

}
