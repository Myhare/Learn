package 算法练习.力扣练习.动态规划;

public class 不同的子序列 {


    // 求s中t子序列出现的次数
    public int numDistinct(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int n1 = s.length();
        int n2 = t.length();

        int[][] dp = new int[n1][n2]; // dp[i][j]表示s的前i位中包含t的前j位的子序列的长度

        // 初始化dp数组
        for (int i = 0; i < n1; i++) {
            if (i == 0){
                if (chars1[i] == chars2[0]){
                    dp[i][0] = 1;
                }else {
                    dp[i][0] = 0;
                }
            }else {
                if (chars1[i] == chars2[0]){
                    dp[i][0] = dp[i-1][0] + 1;
                }else {
                    dp[i][0] = dp[i-1][0];
                }
            }
        }

        for (int i = 1; i < n1; i++) {
            for (int j = 1; j <= i && j < n2; j++) {
                if (chars1[i] == chars2[j]){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];  // 可以判断是否需要从s的最后一个位置和t的最后一个位置相抵消
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n1-1][n2-1];
    }

    public static void main(String[] args) {
        System.out.println(new 不同的子序列().numDistinct("rabbbit", "rabbit"));
        System.out.println(new 不同的子序列().numDistinct("babgbag", "bag"));
    }

}
