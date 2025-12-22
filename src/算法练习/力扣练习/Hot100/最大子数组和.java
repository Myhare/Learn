package 算法练习.力扣练习.Hot100;

public class 最大子数组和 {

    public static int maxSubArray(int[] nums) {
        if (nums == null){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        // dp实现
        int n = nums.length;
        int max = nums[0];
        // 表示以i为结尾的和最大的子数组
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i-1] > 0 ? dp[i-1] + nums[i] : nums[i];
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));
    }

}
