package 算法练习.力扣练习.深度优先;

public class 路径总和 {


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

    public static int targetSum;


    // 判断二叉树根节点到某个叶子结点是否存在总和为targetSum的路径
    public static boolean hasPathSum(TreeNode root, int _targetSum) {
        targetSum = _targetSum;
        return dfs(root, 0);
    }

    // 深度优先
    public static boolean dfs(TreeNode node, int sum){
        if (node == null){
            return false;
        }
        // 终止条件
        if (node.left == null && node.right == null){
            return targetSum == sum + node.val;
        }

        return dfs(node.left, sum + node.val) || dfs(node.right, sum + node.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1)))
        );

        TreeNode root2 = new TreeNode(1, new TreeNode(2), null);

        TreeNode root3 = new TreeNode(1);

        System.out.println(hasPathSum(root, 22));
        System.out.println(hasPathSum(root2, 1));
        System.out.println(hasPathSum(root3, 1));
    }

}
