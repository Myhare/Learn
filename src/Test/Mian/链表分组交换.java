package Test.Mian;

public class 链表分组交换 {


    public class ListNode {
        int val;
        ListNode next = null;
    }


    public ListNode reorderList (ListNode head) {
        if (head == null){
            return null;
        }
        int count = 0;

        ListNode tempNode, end = head;
        ListNode startNode = new ListNode();
        // startNode.next == head

        while (head.next != null){
            tempNode = head;
            head = head.next;

        }
        return null;
    }

}
