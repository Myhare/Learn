package 算法练习.力扣练习.深度优先;

public class 统计一棵树中好节点的数目 {

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

    public static int count = 0;

    public static int goodNodes(TreeNode root) {
        count = 0;
        dfs(root,root.val);
        return count;
    }

    /**
     * 求当前节点是不是好节点
     * @param node  当前节点
     * @param max   根节点到当前节点的最大值
     */
    public static void dfs(TreeNode node,int max){
        if (node == null){
            return;
        }
        if (node.val >= max){
            count++;
        }
        dfs(node.left,Math.max(node.val,max));
        dfs(node.right,Math.max(node.val,max));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(1, new TreeNode(3), null),
                new TreeNode(4, new TreeNode(1), new TreeNode(5))
        );
        System.out.println(goodNodes(root));
    }

}
