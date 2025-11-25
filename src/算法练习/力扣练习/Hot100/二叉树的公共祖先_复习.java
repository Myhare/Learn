package 算法练习.力扣练习.Hot100;

public class 二叉树的公共祖先_复习 {
    
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

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if (root == p){
            return p;
        }
        if (root == q){
            return q;
        }

        // 分情况讨论
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        if (leftNode != null && rightNode != null){
            // 说明当前节点是公共祖先
            return root;
        }
        if (leftNode != null){
            // 说明左节点是右节点的祖先
            return leftNode;
        }
        if (rightNode != null){
            // 说明有节点是左节点的祖先
            return rightNode;
        }
        return null;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


}
