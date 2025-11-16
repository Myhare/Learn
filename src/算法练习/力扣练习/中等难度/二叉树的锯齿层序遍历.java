package 算法练习.力扣练习.中等难度;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的锯齿层序遍历 {

    /**
     * 判断做处理，双向队列实现
     * @param root
     * @return
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            int n = queue.size();
            LinkedList<Integer> linkedList = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                TreeNode pollNode = queue.poll();
                if (lists.size() % 2 == 0){
                    linkedList.addLast(pollNode.val);
                }else {
                    linkedList.addFirst(pollNode.val);
                }
                if (pollNode.left != null){
                    queue.add(pollNode.left);
                }
                if (pollNode.right != null){
                    queue.add(pollNode.right);
                }
            }
            lists.add(linkedList);
        }
        return lists;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(zigzagLevelOrder(root));
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
