package 算法练习.力扣练习.Hot100;

public class 最长回文子串 {

    public static String longestPalindrome(String s) {
        int n = s.length();
        // 表示i到j之间是否是回文子串
        boolean[][] flags = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            flags[i][i] = true;
        }
        int maxSize = 1;
        int startIndex = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) != s.charAt(j)){
                    continue;
                }
                if (j == i + 1){
                    flags[i][j] = true;
                }else {
                    flags[i][j] = flags[i+1][j-1];
                }
                if (flags[i][j] && j - i + 1> maxSize){
                    maxSize = j - i + 1;
                    startIndex = i;
                }
            }
        }
        return s.substring(startIndex, startIndex + maxSize);
    }

    public static void main(String[] args) {
//        System.out.println(longestPalindrome("babad"));
//        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("a"));
    }

}
