package 算法练习.力扣练习.深度优先;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的前序遍历 {

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

    public static List<Integer> list;

    public static List<Integer> preorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        dfs(root);
        return list;
    }

    // 二叉树的前序遍历
    public static void dfs(TreeNode root){
        if (root==null){
            return;
        }
        list.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                1,
                null,
                new TreeNode(
                        2,
                        new TreeNode(3),
                        null)
        );
        preorderTraversal(root);
        System.out.println(list);
    }

}
