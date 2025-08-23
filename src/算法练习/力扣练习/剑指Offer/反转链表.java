package 算法练习.力扣练习.剑指Offer;

public class 反转链表 {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static ListNode reverseList(ListNode head) {
        // 前一个指针，初始化是null
        ListNode pre = null;
        // 当前指向指针
        ListNode now = head;

        while(now != null){
            ListNode temp = now.next;
            now.next = pre;
            pre = now;
            now = temp;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        ListNode listNode = reverseList(root);
        while (listNode != null){
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }

    }

}
