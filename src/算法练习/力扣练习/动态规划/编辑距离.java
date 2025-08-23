package 算法练习.力扣练习.动态规划;

public class 编辑距离 {

    public int minDistance(String word1, String word2) {

        // 为了方便后面计算，将数组前面加一个空格
        int n1 = word1.length();
        char[] chars1 = new char[n1+1];
        for (int i = 1; i < n1 + 1; i++) {
            chars1[i] = word1.charAt(i-1);
        }
        int n2 = word2.length();
        char[] chars2 = new char[n2+1];
        for (int i = 1; i < n2 + 1; i++) {
            chars2[i] = word2.charAt(i-1);
        }

        int[][] dp = new int[n1+1][n2+1];  // dp[i][j]表示word1的前i个单词到word2的前j个单词需要编辑多少次
        // 初始化dp数组
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n2; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (chars1[i] == chars2[j]){
                    // 如果这两个字符相同，相当于直接抵消掉，等于i-1和j-1
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    // 如果两个字符不相同，可以有插入，删除，替换三种选择，选择三种里面最小的值
                    int min = Integer.MAX_VALUE;
                    // 如果是插人，插入一个word1插入一个相同的字母之后和word2相当于抵消了，所以只需要看dp[i][j-1]
                    min = Math.min(min, dp[i][j-1] + 1);  // 这里加一就是记录当前操作
                    // 如果是删除
                    min = Math.min(min, dp[i-1][j] + 1);
                    // 如果是替换,替换之后相互抵消，相当于看dp[i-1][j-1]
                    min = Math.min(min,dp[i-1][j-1] + 1);
                    // 上面是三种取最小值就是dp[i][j]的值
                    dp[i][j] = min;
                }
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        System.out.println(new 编辑距离().minDistance("horse123", "ros"));
        // System.out.println(new 编辑距离().minDistance("intention", "execution"));
        // System.out.println(new 编辑距离().minDistance("", "a"));
    }

}
