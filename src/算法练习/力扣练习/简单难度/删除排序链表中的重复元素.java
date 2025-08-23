package 算法练习.力扣练习.简单难度;

public class 删除排序链表中的重复元素 {

    /*
        删除排序链表中的重复元素
     */

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        if (head==null){
            return head;
        }
        while (head.next!=null){
            if (head.val==head.next.val){
                head.next = head.next.next;
            }else {
                head = head.next;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode t = head;
        head.setNext(new ListNode(1));
        head = head.next;
        head.setNext(new ListNode(2));
        head = t;
        ListNode listNode = deleteDuplicates(head);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
