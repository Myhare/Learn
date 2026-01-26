package 算法练习.力扣练习.中等难度;


import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Objects;

public class 具有所有最深节点的最小子树 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        TreeNode reNode = subtreeWithAllDeepest(root);
        System.out.println(reNode.val);
    }

    // DFS实现，本质上就是求所有叶子结点的最近的公共祖先
    public static TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).getKey();
    }

    // 获取当前节点下最深的
    public static Pair<TreeNode, Integer> dfs(TreeNode node){
        if (node == null){
            return new Pair<>(node, 0);
        }
        Pair<TreeNode, Integer> leftPair = dfs(node.left);
        Pair<TreeNode, Integer> rightPair = dfs(node.right);
        TreeNode leftKey = leftPair.getKey();
        Integer leftValue = leftPair.getValue();
        TreeNode rightKey = rightPair.getKey();
        Integer rightValue = rightPair.getValue();
        if (Objects.equals(leftValue, rightValue)){
            return new Pair<>(node, leftValue + 1);
        }
        if (leftValue > rightValue){
            return new Pair<>(leftKey, leftValue + 1);
        }else {
            return new Pair<>(rightKey, rightValue + 1);
        }
    }

    // 方法不行，使用BFS不能完全解决
    public static TreeNode subtreeWithAllDeepest2(TreeNode root) {
        if (root == null){
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            int hasNextSize = 0;
            TreeNode tempNode = null;
            for (int i = 0; i < size; i++) {
                TreeNode pollNode = queue.poll();
                if (pollNode.left != null || pollNode.right != null){
                    hasNextSize++;
                    tempNode = pollNode;
                }
                if (pollNode.left != null){
                    queue.offer(pollNode.left);
                }
                if (pollNode.right != null){
                    queue.offer(pollNode.right);
                }
            }
            // 说明记录的这个节点就是最深的子节点
            if (hasNextSize == 1 && tempNode != root){
                return tempNode;
            }
        }

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
