package 算法练习.力扣练习.剑指Offer;

public class 删除链表的节点 {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public static ListNode deleteNode(ListNode head, int val) {
        // 判断第一个节点
        if (head.val == val){
            ListNode temp = head.next;
            head.next = null;
            return temp;
        }
        ListNode pre = head;
        ListNode next = pre.next;

        while (next != null){
            // 判断当前节点的值
            if (next.val == val){
                // 当前前一个节点直接指向后一个节点
                pre.next = next.next;
                break;
            }
            pre = next;
            next = next.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(9);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = null;
        ListNode listNode = deleteNode(listNode1, 5);
        System.out.println(listNode);
    }

}
