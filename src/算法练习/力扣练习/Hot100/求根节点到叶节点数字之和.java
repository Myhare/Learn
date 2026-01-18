package 算法练习.力扣练习.Hot100;


public class 求根节点到叶节点数字之和 {

    public static int sum = 0;

    public static int sumNumbers(TreeNode root) {
        sum = 0;
        dfs(root, "");
        return sum;
    }

    public static void dfs(TreeNode node, String path){
        if (node == null){
            return;
        }
        String tempSum = path + node.val;
        if (node.left == null && node.right == null) {
            sum = sum + Integer.parseInt(tempSum);
            return;
        }
        dfs(node.left, tempSum);
        dfs(node.right, tempSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(sumNumbers(root));
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
