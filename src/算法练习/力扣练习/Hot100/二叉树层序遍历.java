package 算法练习.力扣练习.Hot100;

import java.util.*;

public class 二叉树层序遍历 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        LinkedList<List<Integer>> reList = new LinkedList<>();

        while (!queue.isEmpty()){
            List<Integer> list = new LinkedList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode pollNode = queue.poll();
                list.add(pollNode.val);
                if (pollNode.left != null){
                    queue.offer(pollNode.left);
                }
                if (pollNode.right != null){
                    queue.offer(pollNode.right);
                }
            }
            reList.add(list);
        }

        return reList;
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
