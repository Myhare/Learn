package 自己玩;

import java.util.PriorityQueue;

public class 最大最小堆 {

    public static void main(String[] args) {
        int[] a = {2,17,4,12,8,21,15,33};
        //1，默认实现的是最小堆，元素按照natural ordering排序（自然排序，例如，数字的从小到大）
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for (int i : a) {
            pq.offer(i);
        }

        // while(!pq.isEmpty()) {
            System.out.print(pq);
        // }
    }

}
