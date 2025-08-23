package 算法练习.力扣练习.动态规划;

import java.util.Arrays;

public class 组合总和4 {

    // 回溯，超时
    int count = 0;
    public int combinationSum4(int[] nums, int target) {
        count = 0;
        Arrays.sort(nums);
        boolean[] flags = new boolean[nums.length];
        backTracking(nums, flags, target, 0, 0);
        return count;
    }
    public void backTracking(int[] nums, boolean[] flags, int target, int index, int nowSum){
        if (nowSum == target){
            count++;
            return;
        }
        if (index >= nums.length){
            return;
        }
        for (int i = 0; i < nums.length; i++){
            // 如果值大于target，后面所有值都会大于，直接返回
            if (nowSum + nums[i] > target){
                return;
            }
            // 回溯递归
            backTracking(nums, flags, target, i, nowSum + nums[i]);
        }
    }

    // 动态规划解决
    public int combinationSum2(int[] nums, int target) {
        int[] dp = new int[target + 1]; // dp[i]表示元素之和为i的排列数

        // 初始值
        for (int num : nums) {
            if (num <= target){
                dp[num] = 1;
            }
        }

        for (int i = 1; i <= target; i++) {
            // 遍历nums，如果当前dp[i]的值比nums遍历的值要大，说明可以加上前面的值
            for (int num : nums) {
                if (i > num){
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        int target = 4;
        // System.out.println(new 组合总和4().combinationSum4(nums, target));
        System.out.println(new 组合总和4().combinationSum2(nums, target));
    }

}
