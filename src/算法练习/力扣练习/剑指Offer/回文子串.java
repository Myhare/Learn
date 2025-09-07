package 算法练习.力扣练习.剑指Offer;

public class 回文子串 {

    public static int countSubstrings(String s) {
        int n = s.length();
        // dp[i][j] -> i -> j的字符串是不是回文串
        boolean[][] dp = new boolean[n][n];
        int count = n;

        // dp初始化, 一个字符串肯定是回文串
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // 为了dp[i + 1][j - 1]能够全覆盖， i需要从后往前遍历
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
                // a b b a
                if (dp[i + 1][j - 1]){
                    dp[i][j] = true;
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaaaa"));
    }

}
