package 算法练习.力扣练习.Hot100;

public class K个一组旋转链表 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode newHead = reverseKGroup(head, 2);
//        ListNode newHead = reverseNode(head);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
        System.out.println();
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode pre = newHead;
        while (head != null){
            ListNode now = pre;
            // k个一组反转,判断当前这一组是不是大于等于k
            for (int i = 0; i < k; i++) {
                now = now.next;
                if (now == null){
                    return newHead.next;
                }
            }
            // 反转head到now之间的链表
            ListNode nextNode = now.next;
            now.next = null;
            pre.next = reverseNode(head);
            // 反转后原来的头结点变成尾节点
            head.next = nextNode;

            pre = head;
            head = head.next;
        }

        return newHead.next;
    }

    /**
     * 反转head到下一个为空节点的链表
     * @param head
     * @return
     */
    public static ListNode reverseNode(ListNode head){
        ListNode pre = null;
        ListNode now = head;
        while (now != null){
            ListNode temp = now.next;
            now.next = pre;
            pre = now;
            now = temp;
        }
        return pre;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


}
