package 算法练习.力扣练习.动态规划;

public class 回文子串 {

    public int countSubstrings(String s) {
        int n = s.length();
        int count = n; // 表示回文子串的数量
        // flags[i][j]表示i-j的字符串是不是回文串
        boolean[][] flags = new boolean[n][n];

        // 一个字符串肯定有一个子串
        for(int i = 0; i < n; i++){
            flags[i][i] = true;
        }

        // L表示子串的长度，最少为2。 长度为1的情况前面已经举例了
        for (int L = 2; L <= n; L++){
            for(int i = 0; i < n; i++){
                // 判断 i到j这一段是不是回文串
                int j = i + L - 1;
                // 处理越界
                if (j >= n){
                    break;
                }
                // 判断i和j位置的字符是不是相同
                if (s.charAt(i) == s.charAt(j)){
                    // 判断是不是大于2，防止出现问题
                    if (j - i < 2){
                        flags[i][j] = true;
                        count++;
                    }else {
                        // 如果里面的值是回文串，那么这个也是回文串
                        flags[i][j] = flags[i+1][j-1];
                        if (flags[i][j]){
                            count++;
                        }
                    }
                }

            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new 回文子串().countSubstrings("aaa"));
    }

}
