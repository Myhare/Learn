package 算法练习.力扣练习.深度优先;

public class 二叉树的坡度之和 {

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
    // 求二叉树坡度
    public static int findTilt(TreeNode root) {
        count = 0;
        dfs(root);
        return count;
    }

    // 深度优先遍历，求当前结点的坡度
    public static int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftVal = dfs(root.left);
        int rightVal = dfs(root.right);
        count += Math.abs(leftVal - rightVal);

        // 返回的值是左右所有节点的和，差值只用全局变量count记录
        return leftVal + rightVal + root.val;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode treeNode2 = new TreeNode(4,
                new TreeNode(2, new TreeNode(3), new TreeNode(5)),
                new TreeNode(9, null, new TreeNode(7))
        );
        System.out.println(findTilt(treeNode2));
    }

}
