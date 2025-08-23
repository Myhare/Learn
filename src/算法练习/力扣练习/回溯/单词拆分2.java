package 算法练习.力扣练习.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 单词拆分2 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> reList = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        backTracking(s,wordDict,reList,temp,0);
        return reList;
    }

    public void backTracking(String s,List<String> wordDict,List<String> reList,List<String> temp,int begin){
        // 终止条件
        if(begin >= s.length()){
            reList.add(String.join(" ",temp));
            return;
        }
        for(int i = begin; i < s.length(); i++){
            // 截取从begin到i的子字符串
            String subS = s.substring(begin,i+1);
            if(!wordDict.contains(subS)){
                continue;
            }
            // 将其添加到temp中
            temp.add(subS);
            // 深度优先遍历
            backTracking(s,wordDict,reList,temp,i+1);
            // 回溯
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        List<String> wordDict = Arrays.asList("cat","cats","and","sand","dog");
        System.out.println(new 单词拆分2().wordBreak("catsanddog", wordDict));
    }

}
