package 算法练习.力扣练习.Hot100;

public class 环形链表 {

    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode fast = head.next, slow = head;
        while (fast != slow){
            if (fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }


}
