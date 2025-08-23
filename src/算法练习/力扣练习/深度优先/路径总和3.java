package 算法练习.力扣练习.深度优先;

public class 路径总和3 {

    /*
        给定一个二叉树的根节点 root，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
        路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
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

    // 表示当前节点往下权值和尾targetSum的数量
    public static int pathSum(TreeNode root, int targetSum) {
        if (root==null){
            return 0;
        }

        // 使用当前方法递归遍历二叉树每一个节点
        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left,targetSum);
        ret += pathSum(root.right,targetSum);

        return ret;
    }

    public static int rootSum(TreeNode root, int targetSum){
        if (root==null || targetSum<=0){
            return 0;
        }
        int ret = 0;

        int val = root.val;
        if (val == targetSum){
            ret++;
        }

        // 深度优先遍历
        // ret减去当前节点的val值后，向左右两侧递归后的值
        ret += rootSum(root.left,targetSum-val);
        ret += rootSum(root.right,targetSum-val);

        return ret;
    }

    public static void main(String[] args) {

    }

}
