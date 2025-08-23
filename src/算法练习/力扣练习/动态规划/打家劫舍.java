package 算法练习.力扣练习.动态规划;

public class 打家劫舍 {
//    你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
//    如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
//    给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

    public static int rob(int[] nums){

        int n = nums.length;
        int[] dp = new int[n];
        if (n==1){
            return nums[0];
        }else if (n==2){
            return Math.max(nums[0],nums[1]);
        }
        // 如果有1间房屋，则只能偷一次，如果有两间房屋，则偷两家里面价值最高的一家
        // 如果有三件，当i>=3的时候，可以选择偷或者不偷，如果偷，dp[i]=num[i]+dp[i-2]，如果不偷，dp[i]=d[i-1]
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,3,1};
        System.out.println(rob(nums));
    }


}
