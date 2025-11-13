package 算法练习.力扣练习.Hot100;

import java.util.*;

public class 合并K个升序链表 {


    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        ListNode[] listNodes = {node1};
        mergeKLists(listNodes);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        // 最小堆实现
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        for (ListNode listNode : lists) {
            if (listNode != null){
                priorityQueue.add(listNode);
            }
        }

        ListNode head = new ListNode();
        ListNode tempNode = head;

        while (!priorityQueue.isEmpty()){
            ListNode pollNode = priorityQueue.poll();
            tempNode.next = pollNode;
            tempNode = tempNode.next;
            if (pollNode.next != null){
                priorityQueue.add(pollNode.next);
            }
        }

        return head.next;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


}
