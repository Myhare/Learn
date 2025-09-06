package 算法练习.力扣练习.动态规划;

/**
 * 复习
 */
public class 最长递增子序列_2 {

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] arr2 = {1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(arr2));
    }

    public static int lengthOfLIS(int[] nums) {
        // 10,9,2,5,3,7,101,18
        // 1 ,1
        // 以num[i]结尾的最长递增子序列长度
        int[] dp = new int[nums.length];
        dp[0] = 1;

        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

}
