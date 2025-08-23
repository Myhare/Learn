package 算法练习.力扣练习.动态规划;

public class 最长递增子序列 {


    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // dp表示0-i中nums[i]必须选取时候的最大自增子序列长度
        int[] dp = new int[n];
        dp[0] = 1;  // 第一个数肯定是长度为1的子序列

        // 维护一个最大值
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for(int j = i - 1; j >= 0; j--){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            max = Math.max(dp[i],max);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        int[] nums2 = {0,1,0,3,2,3};
        int[] nums3 = {7,7,7,7,7,7,7};
        int[] nums4 = {0};
        System.out.println(new 最长递增子序列().lengthOfLIS(nums4));
    }

}
