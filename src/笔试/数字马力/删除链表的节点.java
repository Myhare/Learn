package 笔试.数字马力;

public class 删除链表的节点 {


    public class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @param val int整型
     * @return ListNode类
     */
    public ListNode deleteNode (ListNode head, int val) {
        // write code here
        ListNode temp = head.next;
        ListNode pre = head;

        while (temp != null){
            if (temp.val == val){
                pre.next = temp.next;
                return head;
            }
            pre = temp;
            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {

    }

}
