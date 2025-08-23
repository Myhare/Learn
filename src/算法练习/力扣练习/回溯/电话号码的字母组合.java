package 算法练习.力扣练习.回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 电话号码的字母组合 {

    public List<String> letterCombinations(String digits) {
        if (digits.length()==0){
            return new ArrayList<>();
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        int n = digits.length();
        List<String> reList = new ArrayList<>();
        dfs(reList,n,new StringBuilder(),digits.toCharArray(),0,phoneMap);
        return reList;
    }

    public void dfs(List<String> reList,int n,StringBuilder reChar,char[] digitsChar, int digIndex,Map<Character,String> phoneMap){
        if(reChar.length() == n){
            reList.add(new String(reChar));
            return;
        }
        String s = phoneMap.get(digitsChar[digIndex]);
        char[] sChars = s.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            reChar.append(sChars[i]);
            dfs(reList,n,reChar,digitsChar,digIndex+1,phoneMap);
            reChar.deleteCharAt(reChar.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new 电话号码的字母组合().letterCombinations("23"));
    }

}
