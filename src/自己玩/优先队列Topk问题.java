package 自己玩;

import java.util.*;

public class 优先队列Topk问题 {
    public static List<Integer> getTopKElements(List<Integer> collection, int k) {
        // 优先队列
        // Collections.reverseOrder() 返回一个相反的比较器
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, Collections.reverseOrder());
        List<Integer> topKElements = new ArrayList<>();

        for (Integer num : collection) {
            priorityQueue.offer(num);

            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        while (!priorityQueue.isEmpty()) {
            topKElements.add(priorityQueue.poll());
        }

        Collections.reverse(topKElements);  // 将结果反转，使其按照升序排列

        return topKElements;
    }

    public static void main(String[] args) {
        List<Integer> collection = Arrays.asList(7, 5, 9, 3, 1, 8, 6, 4, 2);
        int k = 3;

        List<Integer> topKElements = getTopKElements(collection, k);

        System.out.println("前" + k + "大的数为：" + topKElements);
    }
}
