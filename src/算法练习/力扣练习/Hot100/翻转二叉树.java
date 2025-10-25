package 算法练习.力扣练习.Hot100;

public class 翻转二叉树 {

    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        // 临时节点，防止left修改后数据变了
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
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
