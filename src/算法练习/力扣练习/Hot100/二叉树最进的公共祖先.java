package 算法练习.力扣练习.Hot100;

public class 二叉树最进的公共祖先 {

    /**
     * 根节点DFS向下遍历
     * 如果当前节点是p或者q。 直接返回
     * 如果当前节点是null，直接返回null
     * 如果遍历的时候左右节点都不是null，说明当前节点是p和q的公共祖先.(p\q在左右侧)
     * 如果left==null，right！=null。有两种情况
     *  1. p和q都在right侧。
     *  2. 当前节点是p||q。另一个节点在右侧
     * 如果right==null && left!=null 同理
     */

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if (p == root){
            return p;
        }
        if (q == root){
            return q;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 分情况
        if (left != null && right != null){
            return root;
        }
        if (left == null && right != null){
            return right;
        }
        if (left != null && right == null){
            return left;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);
        root.left = treeNode5;
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        TreeNode treeNode1 = new TreeNode(1);
        root.right = treeNode1;
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        System.out.println(lowestCommonAncestor(root, treeNode5, treeNode1).val);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


}
