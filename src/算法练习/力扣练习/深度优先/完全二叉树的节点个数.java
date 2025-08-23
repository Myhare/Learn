package 算法练习.力扣练习.深度优先;

public class 完全二叉树的节点个数 {


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

    public static int count = 0;

    public static int countNodes(TreeNode root) {
        count = 0;
        if (root==null){
            return 0;
        }
        dfs(root);
        return count;
    }

    public static void dfs(TreeNode root){
        if (root == null){
            return;
        }
        count++;
        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), null)
        );
        System.out.println(countNodes(new TreeNode()));
    }

}
