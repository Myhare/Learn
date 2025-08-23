package 算法练习.力扣练习.回溯;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 二叉树中和为某一值的路径 {
    static class TreeNode {
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

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> reSet = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTracking(root,target,reSet,path,0);
        return new ArrayList<>(reSet);
    }

    public void backTracking(TreeNode node, int target, List<List<Integer>> reSet, List<Integer> path, int sum){
        if (node == null){
            return;
        }
        path.add(node.val);
        sum += node.val;
        // 往左右两边递归
        if (sum == target && node.left == null && node.right == null){
            reSet.add(new ArrayList<>(path));
        }
        backTracking(node.left,target,reSet,path,sum);
        backTracking(node.right,target,reSet,path,sum);
        // 回溯
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7),
                                new TreeNode(2)),
                        null
                ),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4,
                                new TreeNode(5), new TreeNode(1)
                        )
                )
        );
        TreeNode root2 = new TreeNode(1, new TreeNode(2), null);
        TreeNode root3 = new TreeNode(0, new TreeNode(1), new TreeNode(1));
        System.out.println(new 二叉树中和为某一值的路径().pathSum(root, 22));
    }

}
