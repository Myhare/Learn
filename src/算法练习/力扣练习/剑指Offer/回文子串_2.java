package 算法练习.力扣练习.剑指Offer;

public class 回文子串_2 {

    // 给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。
    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }

    public static int countSubstrings(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();
        int count = n;

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
                    dp[i][j] = true;
                    count++;
                    continue;
                }
                if (dp[i+1][j-1]){
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }

}
