package 算法练习.力扣练习.剑指Offer;

public class 连续子数组的最大和 {

    public int maxSubArray(int[] nums) {
        int n = nums.length;

        // dp[i]表示到i下标的连续子数组的最大值
        int[] dp = new int[n];
        dp[0] = nums[0];

        // 维护最大值
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            // 判断dp[i-1]是不是整数，如果是就直接天天加，不然就不添加
            dp[i] = dp[i-1] > 0 ? dp[i-1]+nums[i] : nums[i];
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new 连续子数组的最大和().maxSubArray(nums));
    }
}
