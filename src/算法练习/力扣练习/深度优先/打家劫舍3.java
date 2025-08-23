package 算法练习.力扣练习.深度优先;

// import sun.reflect.generics.tree.Tree;

public class 打家劫舍3 {


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

    public static int rob(TreeNode root) {
        return dfs(root,true);
    }

    /**
     * 深度优先遍历
     * @param root 当前节点
     * @param flag 当前节点偷还是不偷
     * @return
     */
    public static int dfs(TreeNode root,boolean flag){
        if (root==null){
            return 0;
        }
        // 如果当前的节点可以用
        if (flag){
            return Math.max(root.val+dfs(root.left,false)+dfs(root.right,false),dfs(root,false));
        }else {
            return dfs(root.left,true)+dfs(root.right,true);
        }
    }

    public static void main(String[] args) {

    }

}
