package 算法练习.力扣练习.回溯;

import java.util.ArrayList;
import java.util.List;

public class 拆分字符串使唯一子字符串的数目最大 {

    int max = 0;

    public int maxUniqueSplit(String s) {
        max = 0;
        backTracking(s,0,new ArrayList<>());
        return max;
    }

    public void backTracking(String s, int start, List<String> path){
        if (start >= s.length()){
            max = Math.max(max,path.size());
            return;
        }

        // 回溯
        for(int i = start; i < s.length(); i++){
            // 截取子字符串
            String substring = s.substring(start, i + 1);
            // 判断是否重复，剪枝
            if (path.contains(substring)){
                continue;
            }
            path.add(substring);
            backTracking(s,i+1,path);
            path.remove(path.size()-1);
        }

    }

    public static void main(String[] args) {
        System.out.println(new 拆分字符串使唯一子字符串的数目最大().maxUniqueSplit("ababccc"));
        System.out.println(new 拆分字符串使唯一子字符串的数目最大().maxUniqueSplit("aba"));
        System.out.println(new 拆分字符串使唯一子字符串的数目最大().maxUniqueSplit("aa"));
    }

}
