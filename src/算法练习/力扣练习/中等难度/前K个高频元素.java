package 算法练习.力扣练习.中等难度;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 前K个高频元素 {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int[] ints = topKFrequent(arr, 2);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
        System.out.println();
    }

    public static int[] topKFrequent(int[] nums, int k) {
        // int[0]表示nums的值，nums[1]表示出现的频率
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            // 大根堆
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            int[] heapArr = {num, count};
            heap.add(heapArr);
        }

        int[] reArr = new int[k];
        for (int i = 0; i < k; i++) {
            int[] t = heap.poll();
            if (t == null){
                continue;
            }
            reArr[i] = t[0];
        }
        return reArr;
    }

}
