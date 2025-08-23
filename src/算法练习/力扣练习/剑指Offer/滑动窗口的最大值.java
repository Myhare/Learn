package 算法练习.力扣练习.剑指Offer;

import java.util.PriorityQueue;
import java.util.Queue;

public class 滑动窗口的最大值 {


    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0){
            return null;
        }
        int n = nums.length;
        // int[] 长度为n-k+1
        int[] reArray = new int[n-k+1];

        // 通过单调队列实现(index，nums[index])
        Queue<int[]> queue = new PriorityQueue<>((arr1, arr2) -> {
            // 从大到小排列
            return arr2[1] - arr1[1];
        });

        // 先将当前元素添加进去
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{i, nums[i]});
        }
        reArray[0] = queue.peek()[1];

        for (int i = k; i < n; i++){
            // 从第一个下标开始遍历，查看大顶堆顶部的下标
            // 如果顶部元素的下标比窗口的最左侧还要偏左，直接移除
            int left = i - k + 1 ;  // 左侧指针
            int[] peekInts = queue.peek();
            if (peekInts[0] < left){
                // 说明最大值已经不在这个窗口里面
                // 直接删除
                queue.poll();
            }
            // 将当前的值加入优先队列
            queue.offer(new int[]{i, nums[i]});
            // 防止有比较大的值在优先队列顶部
            while (queue.peek()[0] < left){
                queue.poll();
            }
            // 添加滑动窗口的值
            reArray[left] = queue.peek()[1];
        }

        return reArray;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] arr2 = {9,10,9,-7,-4,-8,2,-6};
        int k2 = 5;
        int[] ints = new 滑动窗口的最大值().maxSlidingWindow(arr2, k2);
        for (int num : ints) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
