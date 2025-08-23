package 算法练习.力扣练习.回溯;

import java.util.ArrayList;
import java.util.List;

public class 分割回文串2 {

    // 获取reList中最短的列表
    int min = Integer.MAX_VALUE;

    public int minCut(String s) {
        // 返回将s分成整回文子串的最小操作数
        int n = s.length();

        // 预处理i-j是不是回文串
        char[] chars = s.toCharArray();
        boolean[][] flags = new boolean[n][n];

        for (int j = 0; j < n; j++) {
            for(int i = j; i >= 0; i--){
                if (i == j){
                    flags[i][i] = true;
                }else {
                    if (chars[i] == chars[j]){
                        if(j == i + 1 || flags[i+1][j-1]){
                            flags[i][j] = true;
                        }
                    }
                }
            }
        }


        // backTracking(s,0,new ArrayList<>(),flags);

        // 动态规划方法解决
        int[] dp = new int[n]; // 表示从0-i的位置最少分割次数
        for (int i = 0; i < n; i++) {
            if (flags[0][i]){
                // 如果0-i是回文串，不需要分割
                dp[i] = 0;
            }else {
                // 如果o-i不是回文串,寻找最短的切割次数
                dp[i] = i;  // 最多切割i次
                for(int j = 0; j < i; j++){
                    if (flags[j+1][i]){
                        // 如果当前子串是回文串，相当于只需要前面的最短回文串加一就是的拿钱的最短回文串
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }

            }
        }

        return dp[n-1];
    }

    // 回溯分割子串
    public void backTracking(String s, int start, List<String> path, boolean[][] flags){
        // 终止条件
        if (start == s.length()){
            // 到最后的位置，说明当前已经分割回文串完成
            // 维护最小路径
            min = Math.min(min,path.size());
        }

        // 从当前位置向后进行分割
        for(int i = start; i < s.length();i++){
            // 切割start到i的子串
            String substring = s.substring(start, i+1);
            // 判断当前子串是不是回文串
            if (!flags[start][i]){
                // 如果当前子串不是回文串，直接进入下一个循环
                continue;
            }
            // 当前子串是回文串，回溯
            path.add(substring);
            backTracking(s,i+1,path,flags);
            path.remove(path.size()-1);
        }

    }


    public static void main(String[] args) {
        System.out.println(new 分割回文串2().minCut("ab"));
    }

}
