package 算法练习.力扣练习.回溯;

import java.util.ArrayList;
import java.util.List;

public class 回文串分割4 {

    public boolean checkPartitioning(String s) {

        int n =s.length();
        char[] chars = s.toCharArray();

        boolean[][] flags = new boolean[n][n]; // 表示i-j之间是不是回文串

        for (int j = 0; j < n; j++) {
            for (int i = j; i >= 0; i--) {
                if (i == j){
                    flags[i][j] = true;  // 一个字符肯定是回文串
                }else {
                    // 判断是不是两位数
                    if (j - i == 1){
                        if (chars[i] == chars[j]){
                            flags[i][j] = true;
                        }
                    }else {
                        if (chars[i] != chars[j]){
                            flags[i][j] = false;
                        }else {
                            flags[i][j] = flags[i+1][j-1];
                        }
                    }
                }
            }
        }

        // 直接双指针暴力破解
        for(int i = 0; i < n; i++){
            for (int j = i + 1; j < n - 1;j++){
                if (flags[0][i] && flags[i+1][j] && flags[j+1][n-1]){
                    return true;
                }
            }
        }
        return false;
    }

    // 回溯求子串(超时)
    public boolean backTracking(String s,int start, List<String> path, boolean[][] flags){
        // 终止条件
        if (start == s.length()){
            // System.out.println(path);
            if (path.size() == 3){
                return true;
            }
        }

        for(int i = start; i < s.length(); i++){

            if (flags[start][i]){
                String substring = s.substring(start, i + 1);
                path.add(substring);
                if (backTracking(s,i+1,path,flags)){
                    return true;
                }
                path.remove(path.size()-1);
            }

        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new 回文串分割4().checkPartitioning("abcbdd"));
    }

}
