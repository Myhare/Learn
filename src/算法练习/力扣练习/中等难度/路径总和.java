package 算法练习.力扣练习.中等难度;

public class 路径总和 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        System.out.println(hasPathSum(root, 22));
    }

    // 判断二叉树根节点到某个叶子结点是否存在总和为targetSum的路径
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }


    public static boolean dfs(TreeNode node, int nowSum, int targetSum){
        if (node == null){
            return false;
        }
        if (node.left == null && node.right == null){
            return nowSum + node.val == targetSum;
        }

        return dfs(node.left, nowSum + node.val, targetSum) || dfs(node.right, nowSum + node.val, targetSum);
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
