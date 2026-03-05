package 算法练习.力扣练习.Hot100;

public class 删除链表重复元素 {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null){
            // 直接跳过后面的节点
            while (node.next != null && node.val == node.next.val){
                node.next = node.next.next;
            }
            node = node.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        ListNode newHead = deleteDuplicates(head);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


}
