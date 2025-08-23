package 算法练习.力扣练习.剑指Offer;

public class 树的子结构 {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    // 判断B树是不是A树的子树
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null){
            return false;
        }
        return check(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    // 判断A树是否包含B的树
    public static boolean check(TreeNode A, TreeNode B){
        // B树为空，直接就是子树
        if (B == null){
            return true;
        }
        // 如果A树为空，或者AB树的值不相等，说明不是子树
        if (A == null || A.val != B.val){
            return false;
        }
        return check(A.left, B.left) && check(A.right, B.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode bTree = new TreeNode(4);
        bTree.left = new TreeNode(1);
        bTree.right = new TreeNode(2);

        System.out.println(isSubStructure(root, bTree));
    }

}
