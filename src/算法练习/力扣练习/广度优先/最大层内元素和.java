package 算法练习.力扣练习.广度优先;

import java.util.LinkedList;
import java.util.Queue;

public class 最大层内元素和 {

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

    public static int maxVal = Integer.MIN_VALUE;
    public static int maxLevel = 0; // 层数

    public static int maxLevelSum(TreeNode root) {
        maxVal = Integer.MIN_VALUE;
        maxLevel = 0;
        if (root == null){
            return 0;
        }
        // 广度优先遍历
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        int nowLev = 1; // 当前层数
        while (!queue.isEmpty()){
            // 获取当前队列大小
            int size = queue.size();
            int levelSum = 0;       // 当前层数的和
            // 遍历当前队列，提前控制size的大小可以保证只循环到当前层数的树
            while (size-->0){
                TreeNode poRoot = queue.poll();
                if (poRoot == null){
                    break;
                }
                levelSum += poRoot.val;
                if (poRoot.left!=null){
                    queue.add(poRoot.left);
                }
                if (poRoot.right != null){
                    queue.add(poRoot.right);
                }
            }
            if (maxVal < levelSum){
                maxVal = levelSum;
                maxLevel = nowLev;
            }
            // 当前层数加一
            nowLev++;
        }

        return maxLevel;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(7, new TreeNode(7), new TreeNode(-8)),
                new TreeNode(0)
        );
        TreeNode root2 = new TreeNode(-100,
                new TreeNode(-200, new TreeNode(-20), new TreeNode(-5)),
                new TreeNode(-300, new TreeNode(-10), null)
        );
        System.out.println(maxLevelSum(root2));
    }

}
