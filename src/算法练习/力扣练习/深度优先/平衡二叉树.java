package 算法练习.力扣练习.深度优先;

public class 平衡二叉树 {

    /*
        给定一个二叉树，判断它是否是高度平衡的二叉树。
        本题中，一棵高度平衡二叉树定义为：
        一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     */
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



    public static boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }

        return dfs(root) != -1;
    }

    /**
     * 深度优先遍历,
     * @param root   节点
     * @return
     */
    public static int dfs(TreeNode root){
        if (root==null){
            return 0;
        }

        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);

        if (leftHeight>=0 && rightHeight>=0 && Math.abs(leftHeight-rightHeight)<=1){
            return Math.max(leftHeight,rightHeight) + 1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(isBalanced(root));
    }

}
