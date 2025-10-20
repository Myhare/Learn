package 算法练习.力扣练习.中等难度;

import java.util.ArrayList;
import java.util.List;

public class 路径总和2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(pathSum(root, 22));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> reList = new ArrayList<>();
        dfs(root, targetSum, 0, reList, new ArrayList<>());
        return reList;
    }

    public static void dfs(TreeNode node, int targetSum, int sum, List<List<Integer>> reList, List<Integer> path){
        if (node == null){
            return;
        }
        path.add(node.val);
        if (node.left == null && node.right == null && node.val + sum == targetSum){
            reList.add(new ArrayList<>(path));
        }
        dfs(node.left, targetSum, sum + node.val, reList, path);
        dfs(node.right, targetSum, sum + node.val, reList, path);
        path.remove(path.size() - 1);
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
