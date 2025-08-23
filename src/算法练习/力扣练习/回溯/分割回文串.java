package 算法练习.力扣练习.回溯;

import java.util.ArrayList;
import java.util.List;

public class 分割回文串 {

    public List<List<String>> partition(String s) {
        List<List<String>> reList = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backTracking(reList,s,path,0);
        return reList;
    }

    // 回溯
    public void backTracking(List<List<String>> reList, String s, List<String> path, int begin){
        // 终止条件
        if(begin == s.length()){
            reList.add(new ArrayList<>(path));
            return;
        }

        for(int i = begin;i < s.length(); i++){
            // 判断当前子字符串是不是回文串
            if(!isPartition(s,begin,i)){
                continue;
            }
            // 将当前字符串截取到path中
            path.add(s.substring(begin,i+1));
            // 深度优先遍历剩下的字符串
            backTracking(reList,s,path,i+1);
            // 回溯，将之前下面的路径删除
            path.remove(path.size()-1);
        }

    }

    // 判断字符串s是不是回文串
    public boolean isPartition(String s,int left,int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new 分割回文串().partition("aab"));
    }

}
