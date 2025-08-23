package 算法练习.力扣练习.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 串联字符串的最大长度_问题 {

    int max = 0;
    boolean[] conArr = new boolean[26]; // 表示当前拼接的字符串中有没有存在字母

    public int maxLength(List<String> arr) {
        // 筛选出没有重复字符串的数组
        List<String> masks = new ArrayList<>();
        arr.forEach(s -> {
            if (!isCon(s)){
                masks.add(s);
            }
        });
        int n = masks.size();
        dfs("",0,masks);
        return max;
    }

    public void dfs(String nowS, int index, List<String> masks){
        // 维护最大值
        if (nowS.length() > max){
            max = nowS.length();
        }
        // 边界条件
        if (index == masks.size()){
            return;
        }
        String s = masks.get(index);
        // 有重复的字母，直接跳过
        if (isCan(s)){
            dfs(nowS,index+1,masks);
        }else {
            nowS += s;
            // 将当前添加的字母进行标记
            for (char c : s.toCharArray()) {
                conArr[c - 'a'] = true;
            }
            dfs(nowS,index+1,masks);
            for (char c : s.toCharArray()) {
                conArr[c - 'a'] = false;
            }
            nowS = nowS.substring(0, nowS.length()-masks.get(index).length());
        }

    }

    // 判断字符串s是否已经存在
    public boolean isCan(String s){
        for (char c : s.toCharArray()) {
            if (conArr[c - 'a']){
                return true;
            }
        }
        return false;
    }

    // 判断字符串s中有没有重复的字母
    public boolean isCon(String s){
        for (int i = 0; i < s.length(); i++) {
            if (s.lastIndexOf(s.charAt(i)) != i){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("un", "iq", "ue");
        List<String> list2 = Arrays.asList("cha", "r", "act", "ers");
        List<String> list3 = Arrays.asList("abcdefghijklmnopqrstuvwxyz");
        List<String> list4 = Arrays.asList("aa","bb");
        System.out.println(new 串联字符串的最大长度_问题().maxLength(list1));
        // System.out.println(new 串联字符串的最大长度().isCon("ab"));
    }

}
