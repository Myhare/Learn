package 算法练习.力扣练习.动态规划;

import java.util.HashMap;
import java.util.Map;

public class 打家劫舍3 {


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


    // 最后两个结果超时
    public int rob1(TreeNode root) {
        if (root == null){
            return 0;
        }
        // 当前节点是否选择
        // 选择当前节点的最大利益
        int val1 = root.val;
        if (root.left != null){
            val1 +=  rob1(root.left.left) + rob1(root.left.right);
        }
        if (root.right != null){
            val1 +=  rob1(root.right.left)+rob1(root.right.right);
        }
        // 不选择当前节点
        int val2 = rob1(root.left) + rob1(root.right);
        return Math.max(val1,val2);
    }

    // 优化剪枝，使用HashMap完成数据的记忆
    Map<TreeNode, Integer> map = new HashMap<>();
    public int rob2(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (map.containsKey(root)){
            return map.get(root);
        }
        int val1 = root.val;
        if (root.left != null){
            val1 += rob2(root.left.left) + rob2(root.left.right);
        }
        if (root.right != null){
            val1 += rob2(root.right.left) + rob2(root.right.right);
        }
        int val2 = rob2(root.left) + rob2(root.right);
        int result = Math.max(val1, val2);
        // 可视化记忆,防止后面重复运算
        map.put(root,result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(3, null, new TreeNode(1))
        );
        TreeNode root2 = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                null
        );
        System.out.println(new 打家劫舍3().rob2(root2));
    }


}
