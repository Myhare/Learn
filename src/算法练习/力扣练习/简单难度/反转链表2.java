package 算法练习.力扣练习.简单难度;

public class 反转链表2 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        int count = 1;
        ListNode tempNode = head;
        ListNode leftNode = null;
        ListNode rightNode = null;
        // 标记左右节点
        while(tempNode != null){
            if(count == left){
                leftNode = tempNode;
            }else if(count == right){
                rightNode = tempNode;
            }
            count++;
            tempNode = tempNode.next;
        }

        ListNode pre;
        // 保证pre是left的左节点
        if(head == leftNode){
            pre = null;
        }else{
            pre = rightNode.next;
        }

        ListNode now = leftNode;

        // 临时标记右节点的下一个节点，防止指针交换之后的问题
        ListNode rightNext = rightNode.next;

        while(now != rightNext){
            ListNode temp = now.next;
            now.next = pre;
            pre = now;
            now = temp;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = reverseBetween(head, 2, 4);

        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

}
