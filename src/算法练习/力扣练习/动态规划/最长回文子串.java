package 算法练习.力扣练习.动态规划;

public class 最长回文子串 {

	/*
	 	给你一个字符串 s，找到 s 中最长的回文子串。
		示例 1：
		输入：s = "babad"
		输出："bab"
		解释："aba" 同样是符合题意的答案。
	 */

    public static String longestPalindrome(String s) {
    	if (s.length()==1) {
			return s;
		}

    	int n = s.length();
    	// 创建一个dp二维数组，判断i到j之间是不是回文串
		// 只有 s[i+1:j−1] 是回文串，并且 sss 的第 i 和 j 个字母相同时，s[i:j]才会是回文串。
    	boolean[][] dp = new boolean[n][n];
    	int left = 0;   // 自从从s的哪个位置开始
    	int maxLen = 1;  // 子串的长度

    	char[] chars = s.toCharArray();

    	for (int i = 0; i < n; i++) {
			dp[i][i] = true;  // 一个字符一定是回文串
		}

    	// L表示子串的长度，从2开始
    	for (int L = 2; L <= n; L++) {
    		// 从第i个位置开始的回文串
			for (int i = 0; i < n; i++) {
				int j = i + L - 1;  // 子串长度从2开始，所以这里需要再-1
				if (j>=n) {
					break;
				}
				if (chars[i]!=chars[j]) {  // 说明i到j不可能是回文串
					dp[i][j] = false;
				}else if ( L==2 ) {
					dp[i][j] = true;
				}else {
					// 如果char[i]==char[j]并且长度大于2，说明和dp[i+1][j-1]是相同的
					dp[i][j] = dp[i+1][j-1];
				}
				// 维护最长子串的位置和长度
				if (dp[i][j] && j - i + 1 > maxLen) {
					maxLen = j-i+1;
					left = i;
				}
			}
		}
//    	System.out.println(left+"     "+maxLen);

    	return s.substring(left,left+maxLen);
    }

	public static void main(String[] args) {
		System.out.println(longestPalindrome("bb"));
	}

}
