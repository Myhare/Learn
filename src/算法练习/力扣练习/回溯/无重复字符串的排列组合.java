package 算法练习.力扣练习.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 无重复字符串的排列组合 {

    List<String> reList = null;
    public String[] permutation(String S) {
        reList = new ArrayList<String>();
        int n = S.length();
        boolean[] flags = new boolean[n];
        dfs(flags, S, new StringBuilder(), n);
        return reList.toArray(new String[S.length()]);
    }

    public void dfs(boolean[] flags, String S, StringBuilder nowS, int n){
        if(nowS.length() == n){
            reList.add(new String(nowS));
            return;
        }
        for(int i = 0; i < S.length(); i++){
            if(flags[i]){
                continue;
            }
            // 字符加入字符串
            flags[i] = true;
            nowS.append(S.charAt(i));
            dfs(flags, S, nowS, n);
            flags[i] = false;
            nowS.deleteCharAt(nowS.length()-1);
        }
    }

    public static void main(String[] args) {
        // String[] qwes = new 无重复字符串的排列组合().permutation("qwe");
        String[] qwes = new 无重复字符串的排列组合().permutation("ab");
        for (String qwe : qwes) {
            System.out.println(qwe);
        }
    }

}
