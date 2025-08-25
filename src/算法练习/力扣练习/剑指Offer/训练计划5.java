package 算法练习.力扣练习.剑指Offer;

public class 训练计划5 {

    /**
     * 获取相交链表的相交的节点
     * 双指针循环
     * @param args
     */
    public static void main(String[] args) {
    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB  = headB;
        while (nodeA != nodeB){
            nodeA = nodeA != null ? nodeA.next : headB;
            nodeB = nodeB != null ? nodeB.next : headA;
        }
        // 如果不相交，最后结果会是null
        return nodeA;
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
