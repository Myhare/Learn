package 算法练习.力扣练习.深度优先;

public class 二叉树的最大深度 {


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

    public static int max = 0;

    public static int maxDepth(TreeNode root) {
        max = 0;
        if (root==null){
            return 0;
        }
        dfs(root,1);
        return max;
    }

    // 深度优先遍历
    public static void dfs(TreeNode root, int num){
        if (root==null){
            return;
        }
        dfs(root.left,num+1);
        max = Math.max(max,num);
        dfs(root.right,num+1);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(maxDepth(root));

    }

}
