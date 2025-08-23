package 算法练习.力扣练习.回溯;

// import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class 不同的二叉搜索树2 {

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

    // 求1-n之前的所有二叉搜索树(分治递归解决)
    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        if (n == 0) {
            return ans;
        }
        return fenzhi(1, n);
    }

    public static List<TreeNode> fenzhi(int start,int end){
        // 求start到end构建的所有二叉搜索树
        List<TreeNode> ans = new ArrayList<>();
        // 终止条件
        if(start > end){
            ans.add(null);
            return ans;
        }
        // 只有一个节点的时候进行添加
        if (start == end){
            ans.add(new TreeNode(start));
            return ans;
        }
        for(int i = start; i <= end; i++){
            // 获取当前的左子树
            List<TreeNode> leftTrees = fenzhi(start, i - 1);
            List<TreeNode> rightTrees = fenzhi(i + 1, end);
            // 将左子树和右子树拼成一个完整的树
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = leftTree;
                    treeNode.right = rightTree;
                    ans.add(treeNode);
                }
            }
        }

        return ans;
    }

    // 求1-n之前的所有二叉搜索树（有重复结果）
    public static List<TreeNode> generateTrees2(int n) {
        List<TreeNode> reList = new ArrayList<>();
        // 获取1-n之前的去全排列，然后生成二叉搜索树
        // 全排列列表
        List<List<Integer>> tempList = new ArrayList<>();

        // 获取全排列
        dfs(n,tempList,new ArrayList<>());

        // 直接根据全排列生成二叉搜索树
        for(List<Integer> list: tempList){
            TreeNode treeNode = new TreeNode(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                dfsGetTree(treeNode, list.get(i));
            }
            reList.add(treeNode);
        }

        return reList;
    }

    // 获取1-n之前的全排列
    public static void dfs(int n, List<List<Integer>> tempList, List<Integer> path){
        if (path.size() == n){
            tempList.add(new ArrayList<>(path));
        }
        // 从当前位置向后找全排列
        for(int i = 1; i <= n; i++){
            if (path.contains(i)){
                continue;
            }
            path.add(i);
            dfs(n, tempList, path);
            path.remove((Integer) i);
        }

    }

    // 根据一个整型列表生成二叉搜索数
    public static void dfsGetTree(TreeNode treeNode,int i){
        if (treeNode == null){
            return;
        }
        // 找到从上往下找到位置
        if (i > treeNode.val){
            if (treeNode.right == null){
                treeNode.right = new TreeNode(i);
                return;
            }
            dfsGetTree(treeNode.right,i);
        }else {
            if (treeNode.left == null){
                treeNode.left = new TreeNode(i);
                return;
            }
            dfsGetTree(treeNode.left,i);
        }

    }


    public static void main(String[] args) {
        // List<List<Integer>> tempList = new ArrayList<>();
        // dfs(3,tempList,new ArrayList<>());
        // System.out.println(tempList);
        List<TreeNode> treeNodeList = generateTrees(3);
        System.out.println(treeNodeList);
    }





}
