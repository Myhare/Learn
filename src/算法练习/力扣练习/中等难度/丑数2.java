package 算法练习.力扣练习.中等难度;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class 丑数2 {

    public int nthUglyNumber(int n) {
        // 找出包只包含2、3、5质因数的丑数
        int[] nums = new int[]{2,3,5};
        // TODO 了解PriorityQueue队列是怎么实现排序的
        // PriorityQueue队列自动将队列中的元素进行排序
        Queue<Long> queue = new PriorityQueue();

        Set<Long> set = new HashSet<>();

        queue.offer(1L);  // 1是最小的丑数

        for (int i = 1; i <= n; i++) {
            // 找到第i个丑数
            // 弹出数量
            Long poll = queue.poll();
            if (i == n){
                return poll.intValue();
            }
            // 将这个数和队列相乘
            for (int num : nums) {
                long t = num * poll;
                if (set.contains(t)){
                    continue;
                }
                set.add(t);
                queue.offer(t);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new 丑数2().nthUglyNumber(5));
    }

}
