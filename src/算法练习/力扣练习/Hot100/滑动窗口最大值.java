package 算法练习.力扣练习.Hot100;

import java.util.LinkedList;

public class 滑动窗口最大值 {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];

        // 单调队列
        LinkedList<Integer> queue = new LinkedList<>();

        // 还没有形成窗口
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[i] > queue.peekLast()){
                queue.removeLast();
            }
            queue.addLast(nums[i]);
        }
        res[0] = queue.peek();

        // 此时已经形成窗口了
        for (int i = k; i < nums.length; i++) {
            // 需要移除窗口左边前一个值
            if (!queue.isEmpty() && queue.peekFirst() == nums[i - k]){
                queue.removeFirst();
            }
            // 单点队列，保证队列里面元素都比当前值要小
            while (!queue.isEmpty() && queue.peekLast() < nums[i]){
                queue.removeLast();
            }
            queue.addLast(nums[i]);
            res[i - k + 1] = queue.peekFirst();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] reArr = maxSlidingWindow(arr, 3);
        for (int i = 0; i < reArr.length; i++) {
            System.out.print(reArr[i] + " ");
        }
        System.out.println();
    }

}
