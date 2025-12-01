package 算法练习.力扣练习.Hot100;

import java.util.*;

public class 前K个高频元素 {


    public static int[] topKFrequent(int[] nums, int k) {
        if (k >= nums.length){
            return nums;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] reArr = new int[k];
        for (int i = 0; i < k; i++) {
            int[] poll = priorityQueue.poll();
            if (poll != null) {
                reArr[i] = poll[0];
            }
        }

        return reArr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        for (int i : topKFrequent(arr, 2)) {
            System.out.println(i);
        }
    }

}
