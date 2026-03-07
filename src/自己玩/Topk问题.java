package 自己玩;

import java.util.*;

public class Topk问题 {
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

    public static int getTopK(int[] arr, int k){
        return quickSelect(0, arr.length - 1, arr, k - 1);
    }

    public static int quickSelect(int left, int right, int[] arr, int k){
        if (left >= right){
            return 0;
        }
        int i = left, j = right;
        int standard = arr[left];

        while (i < j){
            // 找到第一个比standard小的数
            while (i < j && arr[j] >= standard){
                j--;
            }
            // 找到第一个比standard大的数
            while (i < j && arr[i] <= standard){
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, left, i);

        if (i > k){
            quickSelect(left, i - 1, arr, k);
        }
        if (i < k){
            quickSelect(i + 1, right, arr, k);
        }
        return arr[k];
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        List<Integer> collection = Arrays.asList(7, 5, 9, 3, 1, 8, 6, 4, 2);
        int k = 3;

        List<Integer> topKElements = getTopKElements(collection, k);
        System.out.println("前" + k + "大的数为：" + topKElements);

        int[] arr = {7, 5, 9, 3, 1, 8, 6, 4, 2};
        System.out.println(getTopK(arr, 3));
    }
}
