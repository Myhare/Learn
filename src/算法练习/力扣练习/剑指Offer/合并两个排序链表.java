package 算法练习.力扣练习.剑指Offer;

public class 合并两个排序链表 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // 反转链表
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

    // 合并两个有序链表
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // 创建一个假的头结点
        ListNode temp = new ListNode(-1);
        ListNode temp2 = temp;

        while (l1 != null || l2 != null){
            // 一边链表到达最后位置
            if (l1 == null){
                temp2.next = new ListNode(l2.val);
                temp2 = temp2.next;
                l2 = l2.next;
                continue;
            }else if (l2 == null){
                temp2.next = new ListNode(l1.val);
                temp2 = temp2.next;
                l1 = l1.next;
                continue;
            }
            // 进行比对
            if (l1.val > l2.val){
                temp2.next = new ListNode(l2.val);
                l2 = l2.next;
            }else {
                temp2.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            temp2 = temp2.next;
        }

        return temp.next;
    }

    public static void main(String[] args) {
        // 1 2 4
        ListNode root1 = new ListNode(1);
        root1.next = new ListNode(2);
        root1.next.next = new ListNode(4);
        // 1 3 4
        ListNode root2 = new ListNode(1);
        root2.next = new ListNode(3);
        root2.next.next = new ListNode(4);
        ListNode listNode = mergeTwoLists(root1, root2);
        System.out.println("合并链表结果：");
        ListNode temp = listNode;
        while (temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
        System.out.println("反转链表结果:");
        ListNode listNode1 = reverseList(listNode);
        temp = listNode1;
        while (temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

}
