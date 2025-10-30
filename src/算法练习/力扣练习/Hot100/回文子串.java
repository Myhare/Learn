package 算法练习.力扣练习.Hot100;

public class 回文子串 {

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }

    public static int countSubstrings(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }

        int n = s.length();
        // 表示i到j之间是不是回文子串
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        // dp初始化,单个字母肯定是回文子串
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) != s.charAt(j)){
                    continue;
                }
                if (j == i + 1){
                    dp[i][j] = true;
                    count++;
                    continue;
                }
                dp[i][j] = dp[i+1][j-1];
                if (dp[i][j]){
                    count++;
                }
            }
        }

        return count;
    }

}
