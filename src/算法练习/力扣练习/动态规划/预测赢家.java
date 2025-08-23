package 算法练习.力扣练习.动态规划;

public class 预测赢家 {

    // 需要保证玩家1每次选择的时候，玩家2下一次选择的值是最小的

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;

        // dp[i][j]表示在i到j的下标中，玩家1能够比玩家2多出多少分数
        // dp[i][j] = num[i] - dp[i+1][j] 和 num[j] - dp[i][j-1] 之间的最大值
        int[][] dp = new int[n][n];

        // 只有这一个数的时候，先手一定比后手多nums[i]
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }

        //
        for(int i = n - 1; i >= 0; i--){
            for (int j = i + 1; j < n; j++){
                dp[i][j] = Math.max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1]);
            }
        }

        return dp[0][n-1] >= 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,2};
        int[] nums2 = new int[]{1,5,233,7};
        System.out.println(new 预测赢家().PredictTheWinner(nums));
    }

}
