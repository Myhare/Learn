package 算法练习.力扣练习.深度优先;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的所有路径 {

    /*
        给一个二叉树的节点，返回根节点到子节点的所有路径
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

    public static List<String> list;

    public static List<String> binaryTreePaths(TreeNode root) {
        list = new ArrayList<>();
        dfs(root,"");
        return list;
    }

    // 深度优先遍历
    public static String dfs(TreeNode root,String path){
        if (root==null){
            return path;
        }
        if (root.left==null && root.right==null){
            path += "->" + root.val;
            list.add(path.substring(2,path.length()));
        }
        dfs(root.left,path+"->"+root.val);
        dfs(root.right,path+"->"+root.val);
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));
        List<String> list = binaryTreePaths(root);
        list.forEach(System.out::println);
    }

}
