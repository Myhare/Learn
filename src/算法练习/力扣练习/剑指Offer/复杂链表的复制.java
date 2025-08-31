package 算法练习.力扣练习.剑指Offer;

import java.util.HashMap;
import java.util.Map;

public class 复杂链表的复制 {

    public static void main(String[] args) {
        Node node = new Node(-1);
        node.random = node;
        Node node1 = copyRandomList(node);
        System.out.println(1);
    }

    public static Node copyRandomList(Node head) {
        // 代码可以优化， next和random可以一起构建
        if (head == null){
            return null;
        }
        // map标记当前节点和复制节点的对应关系
        Map<Node, Node> map = new HashMap<>();
        Node newHead = new Node(head.val);
        Node newNode = newHead;
        map.put(head,newHead);

        Node node = head.next;
        while (node != null){
            newNode.next = new Node(node.val);
            newNode = newNode.next;
            map.put(node, newNode);
            node = node.next;
        }
        // 复杂节点计算
        node = head;
        while (node != null) {
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return newHead;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
