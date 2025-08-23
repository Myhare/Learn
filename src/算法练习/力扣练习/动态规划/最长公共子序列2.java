package 算法练习.力扣练习.动态规划;

public class 最长公共子序列2 {

    public int longestCommonSubsequence(String text1, String text2) {

        int n1 = text1.length();
        int n2 = text2.length();

        // 表示text1的前i个字母到text2的前j个字母的最长公共子序列
        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 1; i <= n1; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n2; j++) {
                char c2 = text2.charAt(j - 1);
                // 判断这两个字符是否相等
                if (c1 == c2){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    // 两个字符串不相等
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[n1][n2];
    }

    public static void main(String[] args) {
        System.out.println(new 最长公共子序列2().longestCommonSubsequence("abcde", "ace"));
    }

}
