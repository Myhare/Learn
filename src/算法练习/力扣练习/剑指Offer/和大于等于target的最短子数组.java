package 算法练习.力扣练习.剑指Offer;

import java.util.Arrays;
import java.util.Map;

public class 和大于等于target的最短子数组 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, arr));
    }

    // 滑动窗口实现
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int min = n + 1;


        int left = 0, right = 0;

        // 蜗牛蠕动法= =
        int sum = 0;
        while (right < n){
            sum += nums[right];
            // 左指针右移
            while (sum >= target){
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }

        return min == n + 1 ? 0 : min;
    }

    // 前缀和+二分法实现
    public static int minSubArrayLen2(int target, int[] nums) {
        int min = Integer.MAX_VALUE;

        int n = nums.length;
        int[] pre = new int[n+1];
        pre[0] = 0;
        for (int i = 0; i < n; i++) {
            pre[i+1] = pre[i] + nums[i];
        }
        // Arrays.binarySearch()

        return 0;
    }

}
