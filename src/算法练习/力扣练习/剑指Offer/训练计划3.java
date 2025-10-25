package 算法练习.力扣练习.剑指Offer;

public class 训练计划3 {

    public static void main(String[] args) {

    }

    // 翻转链表
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode nowNode = head;

        while (nowNode != null){
            ListNode tempNode = nowNode.next;
            nowNode.next = pre;
            pre = nowNode;
            nowNode = tempNode;
        }

        return pre;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
