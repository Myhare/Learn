package 算法练习.力扣练习.广度优先;

import java.util.LinkedList;
import java.util.Queue;

public class 填充每个节点的下一个右侧节点指针 {


    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    // 填充每个节点的右侧节点指针
    public static Node connect(Node root) {
        return null;
    }

    // 深度优先遍历
    public static void dfs(){

    }

    // 广度优先算法解决
    public static Node extentConnect(Node root){
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        // 广度优先遍历
        while (!queue.isEmpty()){
            // 弹出第一个元素
            Node node = queue.poll();

            // 因为入队的方式是总左往右入队的，所以当前队列中所有的节点都在同一层
            if (queue.peek() != null){
                node.next = queue.peek();
            }

            // 将左节点和右节点入队
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
        // // 再遍历一次，将所有最右边的节点指向null
        // Node temp = root;
        // while (temp.right != null){
        //     temp.next = null;
        //     temp = temp.right;
        // }

        return root;
    }

    public static void main(String[] args) {
        Node node = new Node(1,
                new Node(2,
                        new Node(4),
                        new Node(5),
                        null
                ),
                new Node(3,
                        new Node(6),
                        new Node(7),
                        null
                ),
                null
        );
        Node reNode = extentConnect(node);
        System.out.println(reNode);
    }

}
