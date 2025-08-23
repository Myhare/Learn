package 算法练习.力扣练习.深度优先;

public class 恢复二叉搜索树 {

    /*
        给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树
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

    /*
        因为是二叉搜索树，所以中序遍历的时候val肯定是由小到大
        所以只需要记录下不同的值，最后修改就行
     */
    public static TreeNode t1,t2,pre;  // t1，t2代表临时结点，pre用来记录当前循环到当前位置的前一个位置

    public static void recoverTree(TreeNode root) {
        // 初始化参数
        t1 = null;
        t2 = null;
        pre = null;
        dfs(root);
        // 将t1和t2节点的val值进行替换
        int t = t1.val;
        t1.val = t2.val;
        t2.val = t;
    }

    public static void dfs(TreeNode root){
        if (root==null){
            return;
        }

        dfs(root.left);
        // 中间操作
        if (pre!=null && pre.val > root.val){  // 说明当前的节点有问题
            if (t1 == null){
                // 第一次出现前一个节点大于后一个节点，我们记录前一个节点
                t1 = pre;
            }
            // 第二次出现前一个节点小于后一个节点，记录后一个节点
            t2 = root;
        }
        pre = root;
        dfs(root.right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3,
                new TreeNode(1),
                new TreeNode(4, new TreeNode(2), null)
        );

        recoverTree(root);
        System.out.println(root);
    }

}
