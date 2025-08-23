package 算法练习.力扣练习.中等难度;

import java.util.HashMap;
import java.util.Map;

public class 环形链表2 {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 快慢指针
    public static ListNode detectCycle(ListNode head) {
        ListNode a1 = head;
        ListNode a2 = head;

        while (true){
            if (a2 == null || a2.next == null){
                return null;
            }
            // 快慢指针
            a1 = a1.next;
            a2 = a2.next.next;

            if (a1 == a2){
                // 说明指针在环的某个地方碰到了
                break;
            }
        }

        // 用一个新的指针从链表头开始往后同步
        ListNode temp = head;
        while (temp != a1){
            temp = temp.next;
            a1 = a1.next;
        }

        return a1;
    }

    // 使用map记录并且返回
    public static ListNode detectCycle1(ListNode head) {
        // 使用map记录即可
        Map<ListNode, Integer> map = new HashMap();
        ListNode temp = head;
        while(temp != null){
            if (map.containsKey(temp)) {
                return temp;
            }
            map.put(temp, 1);
            temp = temp.next;
        }
        return null;
    }

    public static void main(String[] args) {

    }

}
