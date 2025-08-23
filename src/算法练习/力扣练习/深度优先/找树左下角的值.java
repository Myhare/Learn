package 算法练习.力扣练习.深度优先;

public class 找树左下角的值 {

    /*
        给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
        假设二叉树中至少有一个节点。
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

    public static int maxHeight;
    public static int va;

    public static int findBottomLeftValue(TreeNode root) {
        maxHeight = va = 0;
        dfs(root,0);
        return va;
    }

    /**
     * 深度优先遍历
     * @param root        节点
     * @param numberOfLayers 当前层数
     * @return
     */
    public static void dfs(TreeNode root,int numberOfLayers){
        if (root==null){
            return;
        }
        numberOfLayers++;
        // System.out.println("当前节点值为："+root.val+"   "+"层数为"+numberOfLayers);
        // 因为先遍历左节点再遍历右节点，所以同一层下左节点最先被遍历到
        dfs(root.left,numberOfLayers);
        dfs(root.right,numberOfLayers);
        // 维护最深的节点
        if (numberOfLayers>maxHeight){
            maxHeight = numberOfLayers;
            va = root.val;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2,new TreeNode(4),null),
                new TreeNode(3,new TreeNode(5,new TreeNode(7),null),new TreeNode(6)));
        System.out.println(findBottomLeftValue(treeNode));
    }

}
