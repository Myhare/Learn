package 算法练习.力扣练习.深度优先;

public class 二叉树展开为链表 {

    // 将一个二叉树展开成链表，同样使用TreeNode节点存储，right进行连接

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


    public static void flatten(TreeNode root) {

        // 想要展开成链表，只需要将左节点的值转移到右节点，然后将原本右节点移到转义到右节点后的右下角

        // 因为使用先序遍历会出现空指针的问题，这里使用后序遍历
        if (root==null){
            return;
        }

    }


    public static void main(String[] args) {

    }

}
