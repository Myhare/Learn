package 算法练习.力扣练习.深度优先;

public class 根节点到叶节点数字之和 {

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


    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public static int dfs(TreeNode root,int sum){
        if (root == null){
            return 0;
        }
        sum = 10*sum + root.val;
        if (root.left == null && root.right == null){
            return sum;
        }else {
            return dfs(root.left,sum) + dfs(root.right,sum);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(sumNumbers(root));
    }

}
