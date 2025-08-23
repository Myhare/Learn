package 算法练习.力扣练习.回溯;

import java.util.ArrayList;
import java.util.List;

public class 复原IP地址 {

    public List<String> restoreIpAddresses(String s) {
        List<String> resList = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        backTracking(s,resList,temp,0);
        return resList;
    }

    // begin是当前指向了第几个数字
    public void backTracking(String s,List<String> resList,List<String> temp,int begin){
        if (temp.size() > 4){
            return;
        }
        // 终止条件
        if(begin >= s.length()){
            if (temp.size() == 4){
                resList.add(String.join(".",temp));
            }
            return;
        }
        for(int i = begin; i < begin + 3 && i < s.length(); i++){
            // 截取子字符串
            String ts = s.substring(begin,i+1);
            // 判断子字符串是否符合规定
            // 如果不符合规定，直接剪枝
            if(!isAccord(ts)){
                continue;
            }
            temp.add(ts);
            // 递归，往下一个节点走
            backTracking(s,resList,temp,i+1);
            // 回溯
            temp.remove(temp.size()-1);
        }
    }

    public boolean isAccord(String subS){
        // 多数并且是0的话不是有效的ip地址
        if(subS.length() > 1 && subS.charAt(0)=='0'){
            return false;
        }
        int val = Integer.parseInt(subS);
        return val>=0 && val<=255;
    }

    public static void main(String[] args) {
        System.out.println(new 复原IP地址().restoreIpAddresses("25525511135"));
    }

}
