package 算法练习.力扣练习.剑指Offer;


import java.util.HashMap;
import java.util.Map;

public class 重建二叉树 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int[] preorder;
    int[] inorder;
    // 中序遍历的值:下标
    Map<Integer,Integer> map = new HashMap<>();


    // 前序遍历 中序遍历
    public TreeNode buildTree(int[] _preorder, int[] _inorder) {
        preorder = _preorder;
        inorder = _inorder;

        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }

        return fenzhi(0,0,inorder.length-1);
    }

    /**
     * 分治构建二叉树，对中序遍历进行分治
     * @param pre_index 先序遍历的下标
     * @param in_left   中序遍历的左边界
     * @param in_right  中序遍历的右边界
     */
    public TreeNode fenzhi(int pre_index,int in_left, int in_right){
        // 终止条件
        if(in_left > in_right){
            // 说明到达叶子结点下面，直接返回空
            return null;
        }
        // 获取前序遍历的第一个节点，这个就是根节点
        TreeNode treeNode = new TreeNode(preorder[pre_index]);

        Integer ino_index = map.get(preorder[pre_index]);

        treeNode.left = fenzhi(pre_index+1, in_left,ino_index-1);
        treeNode.right = fenzhi(pre_index+(ino_index-in_left)+1,ino_index+1,in_right);

        return treeNode;
    }

    public static void main(String[] args) {
        int[] pr = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        TreeNode treeNode = new 重建二叉树().buildTree(pr, in);
        System.out.println(1);
    }

}
