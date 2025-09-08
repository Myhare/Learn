package 算法练习.力扣练习.中等难度;

public class 最长回文子串 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaa"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return "";
        }
        int n = s.length();
        int max = 1;
        String reString = String.valueOf(s.charAt(0));
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) != s.charAt(j)){
                    continue;
                }
                if (j == i + 1){
                    if (j - i + 1 > max){
                        max = j - i + 1;
                        reString = s.substring(i, j + 1);
                    }
                    dp[i][j] = true;
                    continue;
                }
                dp[i][j] = dp[i + 1][j - 1];
                if (dp[i][j] && j - i + 1 > max){
                    max = j - i + 1;
                    reString = s.substring(i, j + 1);
                }
            }
        }

        return reString;
    }

}
