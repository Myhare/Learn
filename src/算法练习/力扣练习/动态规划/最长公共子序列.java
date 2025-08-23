package 算法练习.力扣练习.动态规划;

public class 最长公共子序列 {

    // 给定两个字符串text1 和text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
    // 一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
    // 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
    // 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。

    // 创建一个dp[][]数组，表示test1的0-i和test2的0-j之间的最长公共子序列

    public static int longestCommonSubsequence(String text1, String text2) {
        // dp[i][j] 表示test1的0-i的子字符串和test2的0-j的子字符串的最长公共子序列的长度
        int[][] dp = new int[text1.length()+1][text2.length()+1];

        for (int i = 1; i <= text1.length(); i++) {
            char c1 = text1.charAt(i-1);
            for (int j = 1; j <= text2.length(); j++) {
                // if (i==0 || j==0){
                //     dp[i][j] = 0;
                //     continue;
                // }
                char c2 = text2.charAt(j-1);
                // 如果两个字符串相同，就等于两个字符串的的前一个子串的最大子串加一
                if (c1 == c2){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    // 不然就是比较前面两个状态的最大值
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {

        String test1 = "adcde";
        String test2 = "ace";
        System.out.println(longestCommonSubsequence(test1,test2));

    }

}
