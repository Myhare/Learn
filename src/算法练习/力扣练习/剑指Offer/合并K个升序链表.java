package 算法练习.力扣练习.剑指Offer;

import java.util.*;

public class 合并K个升序链表 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);
        List<ListNode> list = new ArrayList<>();
        list.add(node1);
        list.add(node2);
        list.add(node3);
        ListNode mergeNode = mergeKLists(list.toArray(new ListNode[0]));
        while (mergeNode != null){
            System.out.print(mergeNode.val + " ");
            mergeNode = mergeNode.next;
        }
        System.out.println();
    }

    // 最小堆实现
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        for (ListNode node : lists) {
            if (node != null){
                queue.add(node);
            }
        }

        ListNode head = new ListNode();
        ListNode cur = head;
        while (!queue.isEmpty()){
            ListNode pollNode = queue.poll();
            cur.next = pollNode;
            cur = cur.next;
            // 下一个节点可能是null
            if (pollNode.next != null){
                queue.add(pollNode.next);
            }
        }

        return head.next;
    }

    // TODO 分治实现

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


}
