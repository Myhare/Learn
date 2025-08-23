package 算法练习.力扣练习.剑指Offer;

import 算法练习.力扣练习.动态规划.回文子串;

public class 回文子字符串的个数 {


    // 动态规划解决
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        // dp[i][j]表示下标i到j之间的子串是不是回文串
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true; // 一个字母肯定是回文串
            count++;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++){
                if (s.charAt(i) == s.charAt(j)){
                    // 判断是不是相邻的字符串，如果是相邻的，这就是回文串
                    if (j == i + 1){
                        dp[i][j] = true;
                    }else {
                        // 说明字符串长度大于3
                        dp[i][j] = dp[i+1][j-1];
                    }
                    if (dp[i][j]){
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private int count = 0;
    // 回溯暴力解决
    public int countSubstrings2(String s) {
        count = 0;
        dfs(0,s);
        return count;
    }
    public void dfs(int start, String s){
        // 终止条件
        if (start == s.length()){
            return;
        }
        for (int i = start; i < s.length(); i++){
            // 判断start到i之间的字符串是不是回文串
            String substring = s.substring(start, i + 1);
            // 如果不是回文串就跳转到下一个子串
            if (!isHui(substring)){
                continue;
            }
            // 走到这里说明这一段子串是回文串
            count++;
        }
        dfs(start + 1, s);
    }

    public boolean isHui(String s){
        int i = 0;
        int j = s.length() - 1;
        while (i <= j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public static void main(String[] args) {
        // System.out.println(new 回文子字符串的个数().countSubstrings("abc"));
        System.out.println(new 回文子字符串的个数().countSubstrings("aaa"));
    }

}
