package 算法练习.力扣练习.中等难度;

public class 两数相加 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode node = head;

        int carry = 0;

        while (l1 != null || l2 != null){
            int l1Value = l1 == null ? 0 : l1.val;
            int l2Value = l2 == null ? 0 : l2.val;

            int tempValue = l1Value + l2Value + carry;
            carry = tempValue / 10;

            node.next = new ListNode(tempValue % 10);
            node = node.next;

            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        if (carry != 0){
            node.next = new ListNode(carry);
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);
        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);
        ListNode node = addTwoNumbers(listNode1, listNode2);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
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
