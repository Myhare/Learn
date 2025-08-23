package 算法练习.力扣练习.动态规划;

import java.util.Arrays;
import java.util.List;

public class 单词拆分 {

    int n = 0;

    public boolean wordBreak(String s, List<String> wordDict) {
        n = s.length();

        boolean[] dp = new boolean[n+1]; // dp[i]表示0-i是否合法

        // 空字符串是ture
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++){
                String s2 = s.substring(j, i);
                if (dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }

        }
        return dp[n];

        // dp[i][j]表示i-j的子字符串是否在字典中
        // boolean[][] flags = new boolean[n][n];
        // for (int i = 0; i < n; i++) {
        //     for (int j = i; j < n; j++){
        //         String substring = s.substring(i, j + 1);
        //         flags[i][j] = wordDict.contains(substring);
        //     }
        // }
        // return backTracking(0, n, flags);
        // return dfs(0, s, wordDict);
    }

    // 判断left到right是否可以由字典构成(超时)
    public boolean backTracking(int left, int right, boolean[][] flags){
        if (left >= right){
            return true;
        }
        if (flags[left][right-1]){
            return true;
        }
        for(int i = left; i < right; i++){
            if (flags[left][i] && backTracking(i+1, right, flags)){
                return true;
            }
        }
        return false;
    }

    // 递归暴力解决，超时
    // 表示从start开始到最后是否可以使用字典凑出来
    public boolean dfs(int start, String s, List<String> wordDict){
        if (start >= n){
            return true;
        }
        // 截取字符串
        for(int i = start; i < n; i++){
            String substring = s.substring(start, i + 1);
            // 判断当前子串是否在字典中
            if (!wordDict.contains(substring)){
                continue;
            }
            // 当前存在，递归
            if (dfs(i+1,s,wordDict)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new 单词拆分().wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(new 单词拆分().wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(new 单词拆分().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        System.out.println(new 单词拆分().wordBreak("aaaaaaa", Arrays.asList("aaaa","aaa")));
        System.out.println(new 单词拆分().wordBreak("goalspecial", Arrays.asList("go","goal","goals","special")));
    }

}
