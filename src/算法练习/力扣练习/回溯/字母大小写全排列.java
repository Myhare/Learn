package 算法练习.力扣练习.回溯;

import java.util.ArrayList;
import java.util.List;

public class 字母大小写全排列 {

    List<String> reList = new ArrayList<String>();
    List<String> path = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        reList = new ArrayList<String>();
        path = new ArrayList<>();
        backTracking(s,0);
        return reList;
    }

    public void backTracking(String s,int begin){
        // 边缘条件
        if(begin == s.length()){
            reList.add(String.join("",path));
            return;
        }
        char c = s.charAt(begin);
        // 大写字母
        if(c >= 65 && c <= 90){
            path.add(c+"");
            backTracking(s,begin+1);
            path.remove(path.size()-1);
            // 转化成小写字母
            path.add((char) (c + 32) + "");
            backTracking(s,begin+1);
            path.remove(path.size()-1);
        }else if(c >= 92){
            // 小写字母
            path.add(c+"");
            backTracking(s,begin+1);
            path.remove(path.size()-1);
            // 转化成大写字母
            path.add((char) (c - 32) + "");
            backTracking(s,begin+1);
            path.remove(path.size()-1);
        }else{
            // 数字
            path.add(c + "");
            backTracking(s,begin+1);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new 字母大小写全排列().letterCasePermutation("3z4"));
    }

}
