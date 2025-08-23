package 算法练习.力扣练习.动态规划;

import java.util.Scanner;

public class 最长回文串 {

    // 算法：动态规划

    //    给你一个字符串s找出其中最长的回文子序列，并返回该序列的长度。
//    子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
//    输入：s = "bbbab"
//    输出：4
//    解释：一个可能的最长回文子序列为 "bbbb"
    public static void main(String[] args) {

        // 创建一个dp[i][j]代表从第i到j个字符串的最大回文串的长度
        // 因为一个字符的回文串的长度肯定是1，所以dp[i][i]的长度是1
        // 令对s[i]和s[j]进行对比，如果s[i]=s[j]，dp[i][j]值等于dp[i+1][j-1]+2
        // 如果是s[i]!=s[j]，则dp[i][j]=max(dp[i+1][j],dp[i][j-1])
        // 因为
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();

        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--){
            dp[i][i] = 1;    // 每一个单独的字符串的最大回文串长度都是1
            for (int j = i + 1; j < n; j++){
                if (s.charAt(i)==s.charAt(j)){   // 如果这两个字符相等，则i-j的回文串的长度最大值为i+1到j-1的最大值加2
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {   // 否则等于max(dp[i+1][j],dp[i][j-1])
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[0][n-1]);



    }


}
