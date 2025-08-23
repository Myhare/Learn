package 算法练习.力扣练习.剑指Offer;

public class 戳气球 {

    public int maxCoins(int[] nums) {

        int n = nums.length;

        // 重新弄一个数组，假设两边有为1的气球
        int[] nums2 = new int[n+2];
        nums2[0] = 1;
        nums2[n+1] = 1;
        for (int i = 1; i < n + 1; i++) {
            nums2[i] = nums[i-1];
        }
        // 此时数组nums2之间有效的气球是1-n之间（闭区间）

        // dp[i][j]表示i到j之间戳破气球的最大硬币数量（开区间）
        int[][] dp = new int[n+2][n+2];

        // 假设i-j之间戳破气球的最后一个气球是k
        // dp[i][j] = dp[i][k] + dp[k][j] + nums2[i] * nums2[k] * nums2[j] // 然后求最大值即可


        // 从下往上，从左往右遍历
        for(int i = n; i >= 0; i--){
            // 从i+2开始遍历（开区间），这样至少中间有一个气球。
            for (int j = i + 2; j < n + 2; j++){
                // 遍历i到j之间最后戳破的气球下标k
                for (int k = i + 1; k < j; k++){
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + nums2[i] * nums2[k] * nums2[j]);
                }
            }
        }

        return dp[0][n+1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,5,8};
        int[] nums2 = new int[]{1,5};
        System.out.println(new 戳气球().maxCoins(nums));
    }

}
