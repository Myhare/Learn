package 算法练习.力扣练习.深度优先;

public class 修剪二叉搜索树 {

    /*
        给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。
        通过修剪二叉搜索树，使得所有节点的值在[low, high]中。
        修剪树 不应该改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在唯一的答案。
         所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
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


    // 深度优先遍历
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root==null){
            return root;
        }
        // 边缘条件
        // 因为这是二叉搜索树，如果val大于high，代表所有左边的节点都大于high
        // 所以舍弃右边的树，进入左边的树
        if (root.val>high){
            return trimBST(root.left,low,high);
        }
        if (root.val<low){
            return trimBST(root.right,low,high);
        }
        // 正常的节点
        // 这里的root是当前正常的root节点，但是左右节点已经经过递归自动剔除了不符合要求的节点
        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low,high);

        return root;
    }

    public static void main(String[] args) {

    }

}
